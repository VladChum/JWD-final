package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Status;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.SubscriptionService;
import com.epam.jwd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

public class UpdateUserTariff implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserTariff.class);

    private static final String USER_PAGE = "/Controller?command=userPage";
    private static final String USER = "user";
    private static final String TARIFF_ID = "tariffId";

    private final SubscriptionService subscriptionService = ServiceProvider.INSTANCE.getSubscriptionService();
    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        try {
            if (userService.findUserByAccountId((Long) session.getAttribute(USER)).isPresent()) {
                User user = userService.findUserByAccountId((Long) session.getAttribute(USER)).get();
                Long newTariffId = Long.valueOf(req.getParameter(TARIFF_ID));
                Long activeSubscriptionId = null;
                if (subscriptionService.findActiveUserSubscription(user.getId()) != null) {
                    activeSubscriptionId = subscriptionService.findActiveUserSubscription(user.getId()).getId();
                    subscriptionService.stopActiveSubscription(user.getId(), activeSubscriptionId);
                } else {
                    userService.changeStatus(user, Status.ACTIVATE.getId());
                }
                subscriptionService.newSubscription(user.getId(), newTariffId);

                if (user.getBalance().compareTo(BigDecimal.valueOf(0)) >= 0 && !user.getStatus().getId().equals(Status.BANNED.getId())) {
                    userService.changeStatus(user, Status.ACTIVATE.getId());
                }
            }
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage() + " " + e);
        }

        resp.sendRedirect(USER_PAGE);
    }
}
