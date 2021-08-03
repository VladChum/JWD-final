package com.epam.jwd.controller.command.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Account;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;
import com.epam.jwd.service.AdminService;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignIn.class);

    private static final String ACCOUNT = "account";
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();
    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        HttpSession session = req.getSession();

        try {
            if (!accountService.findAccountByLoginAndPassword(login, password).isPresent()) {
                resp.getWriter().write("false");
            } else {
                Account account = accountService.findAccountByLoginAndPassword(login, password).get();
                session.setAttribute(ACCOUNT, account);
                LOGGER.debug("change account in session " + account.getId());

                if (adminService.findAdminByAccountId(account.getId()).isPresent()) {
                    session.setAttribute(ADMIN, adminService.findAdminByAccountId(account.getId()).get().getAccountId());
                } else if (userService.findUserByAccountId(account.getId()).isPresent()) {
                    session.setAttribute(USER, userService.findUserByAccountId(account.getId()).get().getAccountId());
                }
            }
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
