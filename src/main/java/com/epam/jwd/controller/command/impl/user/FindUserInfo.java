package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Account;
import com.epam.jwd.entity.Subscription;
import com.epam.jwd.entity.TariffPlan;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.*;
import com.epam.jwd.service.impl.ServiceProvider;
import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindUserInfo implements Command {
    private static final Logger LOGGER = Logger.getLogger(FindUserInfo.class);

    private static final String USER_ID = "userId";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final SubscriptionService subscriptionService = ServiceProvider.INSTANCE.getSubscriptionService();
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));

        try {
            if (userService.findUserById(userId).isPresent()) {
                User user = userService.findUserById(userId).get();
                if (accountService.findAccountById(user.getAccountId()).isPresent()) {
                    Account account = accountService.findAccountById(user.getAccountId()).get();
                    Subscription subscription = subscriptionService.findActiveUserSubscription(userId);

                    List<Object> userInfo = new ArrayList<>();
                    userInfo.add(user);
                    userInfo.add(account.getLogin());
                    userInfo.add(subscription);

                    if (subscription != null) {
                        TariffPlan tariffPlan = tariffService.findById(subscription.getTariffPlanId().intValue());
                        userInfo.add(tariffPlan);
                    }

                    String resultJson = new Gson().toJson(userInfo);

                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(resultJson);
                }
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
