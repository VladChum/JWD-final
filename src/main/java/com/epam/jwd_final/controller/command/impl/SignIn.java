package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.AdminService;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn implements Command {
    private static final Logger LOGGER = Logger.getLogger(SignIn.class);
    private final String ACCOUNT = "account";
    private final String ADMIN = "admin";
    private final String USER = "user";
    private final String SIGN_IN_USER = "/Controller?command=userPage";
    private final String SIGN_IN_ADMIN = "/Controller?command=adminPage";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();
    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        HttpSession session = req.getSession();
        String nextPage = "";

//      temporary solution
        try {
            if (!accountService.findAccountByLoginAndPassword(login, password).isPresent()) {
                nextPage = "/Controller?command=homePage";
            } else {
                Account account = accountService.findAccountByLoginAndPassword(login, password).get();
                if (session.getAttribute(ACCOUNT) == null) {
                    session.setAttribute(ACCOUNT, account);
                    LOGGER.log(Level.DEBUG, "add account in session: " + account.getId());
                } else {
                    session.setAttribute(ACCOUNT, account);
                    LOGGER.log(Level.DEBUG, "cheng account in session " + account.getId());
                }
                if (adminService.findAdminByAccountId(account.getId()).isPresent()) {
                    nextPage = SIGN_IN_ADMIN;
                    session.setAttribute(ADMIN, adminService.findAdminByAccountId(account.getId()).get().getAccountId());
                } else if (userService.findUserByAccountId(account.getId()).isPresent()) {
                    nextPage = SIGN_IN_USER;
                    session.setAttribute(USER, userService.findUserByAccountId(account.getId()).get().getAccountId());
                }
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage(), e);
        }

        resp.sendRedirect(nextPage);
    }
}
