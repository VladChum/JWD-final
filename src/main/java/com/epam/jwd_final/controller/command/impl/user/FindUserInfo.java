package com.epam.jwd_final.controller.command.impl.user;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.*;
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
    private static final String LOGIN = "login";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String STATUS = "status";
    private static final String TARIFF = "tariff";


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
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
