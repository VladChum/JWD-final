package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.SubscriptionService;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateTariff implements Command {
    private static final Logger LOGGER = Logger.getLogger(UserPage.class);

    private final String USER_PAGE = "/Controller?command=userPage";
    private final String USER = "user";
    private final SubscriptionService subscriptionService = ServiceProvider.INSTANCE.getSubscriptionService();
    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        try {
            User user = userService.findUserByAccountId((Long) session.getAttribute(USER)).get();
            /**ToDo
             * cheng
             * newTariffId = get from from user page
            * */
            Long newTariffId = 2L;
            Long activeSubscriptionId = null;
            if (subscriptionService.findActiveUserSubscription(user.getId()) != null) {
                activeSubscriptionId = subscriptionService.findActiveUserSubscription(user.getId()).getId();
            }
            subscriptionService.stopActiveSubscription(user.getId(), activeSubscriptionId);
            subscriptionService.newSubscription(user.getId(), newTariffId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(USER_PAGE);
    }
}
