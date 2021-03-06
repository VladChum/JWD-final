package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Admin;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;
import com.epam.jwd.service.AdminService;
import com.epam.jwd.service.impl.ServiceProvider;
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

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        try {
            if (!accountService.checkExistence(login)) {
                Long accountId = accountService.addAccount(login, password);
                Admin admin = new Admin(1L, accountId);
                adminService.createAdmin(admin);
            } else {
                resp.getWriter().write("error: account with this login already exists!");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
