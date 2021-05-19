package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(UserPage.class);

    private final String USER_PAGE = "/WEB-INF/jsp/user.jsp";
    private final String TARIFF_PLANS = "tariffPlans";
    private final String SUBSCRIPTION = "subscription";
    private final String ACCOUNT = "account";
    private final String USER = "user";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();
    private final SubscriptionService subscriptionService = ServiceProvider.INSTANCE.getSubscriptionService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession();
            User user = userService.findUserByAccountId((Long) session.getAttribute(USER)).get();
            Account account = accountService.findAccountById(user.getAccountId()).get();
            List<TariffPlan> tariffPlans = tariffService.findAllTariff();
            Subscription subscription = subscriptionService.findActiveUserSubscription(user.getId());
            req.setAttribute(USER, user);
            req.setAttribute(ACCOUNT, account);
            req.setAttribute(TARIFF_PLANS, tariffPlans);
            req.setAttribute(SUBSCRIPTION, subscription);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
