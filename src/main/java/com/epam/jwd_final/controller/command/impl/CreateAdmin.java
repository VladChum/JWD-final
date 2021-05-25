package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.AdminService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAdmin implements Command {
    private static final Logger LOGGER = Logger.getLogger(CreateAdmin.class);

    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        try {
            Long accountId = accountService.addAccount(login, password);
            Admin admin = new Admin(1L, accountId);
            adminService.createAdmin(admin);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
