package com.epam.jwd_final.controller.command.impl.page;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.*;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.*;
import com.epam.jwd_final.service.impl.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(AdminPage.class);

    private static final String ADMIN_PAGE = "/WEB-INF/jsp/admin.jsp";
    private static final String USERS = "users";
    private static final String ADMINS = "admins";
    private static final String TARIFFS = "tariffs";
    private static final String DISCOUNT = "discounts";
    private static final String ACTIVE_USERS = "activeUsers";
    private static final String BANED_USERS = "banedUsers";
    private static final String SUSPENDED_USERS = "suspendedUsers";
    private static final String ACTIVE_TARIFFS = "activeTariffs";
    private static final String ARCHIVE_TARIFFS = "archiveTariffs";
    private static final String PLANED_DISCOUNTS = "planedDiscounts";
    private static final String ACTIVE_DISCOUNTS = "activeDiscounts";
    private static final String ARCHIVE_DISCOUNTS = "archiveDiscounts";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();
    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            List<User> users = userService.findAll();
            List<Account> adminAccounts = adminService.findAllAdminAccounts();
            List<TariffPlan> tariffs = tariffService.findAllTariff();
            List<Discount> discounts = discountService.findAll();
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int[] usersByStatus = userService.findAllUsersByStatus(users);
            int[] tariffsByStatus = tariffService.findTariffsByStatus(tariffs);
            int[] discountsByStatus = discountService.findDiscountsByStatus(discounts);

            req.setAttribute(USERS, users);
            req.setAttribute(ADMINS, adminAccounts);
            req.setAttribute(TARIFFS, tariffs);
            req.setAttribute(DISCOUNT, discounts);
            req.setAttribute(ACTIVE_USERS, usersByStatus[0]);
            req.setAttribute(BANED_USERS, usersByStatus[1]);
            req.setAttribute(SUSPENDED_USERS, usersByStatus[2]);
            req.setAttribute(ACTIVE_TARIFFS, tariffsByStatus[0]);
            req.setAttribute(ARCHIVE_TARIFFS, tariffsByStatus[1]);
            req.setAttribute(ACTIVE_DISCOUNTS,discountsByStatus[0]);
            req.setAttribute(PLANED_DISCOUNTS, discountsByStatus[1]);
            req.setAttribute(ARCHIVE_DISCOUNTS, discountsByStatus[2]);
            req.setAttribute("dateNow", java.sql.Date.valueOf(dateFormat.format(date)));
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADMIN_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
