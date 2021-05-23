package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AdminService;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.TariffService;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(AdminPage.class);

    private final String ADMIN_PAGE = "/WEB-INF/jsp/admin.jsp";
    private final String USERS = "users";
    private final String ADMINS = "admins";
    private final String TARIFFS = "tariffs";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            List<User> users = userService.findAll();
            List<Account> adminAccounts = adminService.findAllAdminAccounts();
            List<TariffPlan> tariffs = tariffService.findAllTariff();

            req.setAttribute(USERS, users);
            req.setAttribute(ADMINS, adminAccounts);
            req.setAttribute(TARIFFS, tariffs);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADMIN_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
