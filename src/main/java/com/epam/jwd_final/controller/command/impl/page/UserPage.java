package com.epam.jwd_final.controller.command.impl.page;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.*;
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
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(UserPage.class);

    private static final String USER_PAGE = "/WEB-INF/jsp/user.jsp";
    private static final String TARIFF_PLANS = "tariffPlans";
    private static final String SUBSCRIPTION = "subscription";
    private static final String ACCOUNT = "account";
    private static final String USER = "user";
    private static final String DISCOUNT = "discounts";
    private static final String USER_PAYMENTS = "userPayments";
    private static final String ACTIVE_DAYS = "activeDays";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();
    private final SubscriptionService subscriptionService = ServiceProvider.INSTANCE.getSubscriptionService();
    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();
    private final PaymentService paymentService = ServiceProvider.INSTANCE.getPaymentService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession();
            User user = userService.findUserByAccountId((Long) session.getAttribute(USER)).get();
            Account account = accountService.findAccountById(user.getAccountId()).get();

            List<TariffPlan> tariffPlans = tariffService.findAllTariff();
            List<Discount> discounts = discountService.findAll();
            List<UserPayment> userPayments = paymentService.findAllUserPayments(user.getId());

            Subscription subscription = subscriptionService.findActiveUserSubscription(user.getId());
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Collections.reverse(userPayments);

            int activeDays = tariffService.beforePaymentDays(user, subscription.getTariffPlanId());

            req.setAttribute(USER, user);
            req.setAttribute(ACCOUNT, account);
            req.setAttribute(ACTIVE_DAYS, activeDays);
            req.setAttribute(TARIFF_PLANS, tariffPlans);
            req.setAttribute(SUBSCRIPTION, subscription);
            req.setAttribute(DISCOUNT, discounts);
            req.setAttribute("dateNow", java.sql.Date.valueOf(dateFormat.format(date)));
            req.setAttribute(USER_PAYMENTS, userPayments);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
