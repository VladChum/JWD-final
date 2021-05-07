package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.impl.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn implements Command {
    private static final Logger LOGGER = Logger.getLogger(SignIn.class);
    private final String ACCOUNT = "account";
    private final String SIGN_IN_USER = "/Controller?command=userPage";
    private final String SIGN_IN_ADMIN = "/Controller?command=adminPage";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    public SignIn() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        HttpSession session = req.getSession();

        System.out.println(login);
        System.out.println(password);
        String nextPage = "";

//      temporary solution
        try {
            if (!ServiceProvider.INSTANCE.getAccountService().findAccountByLoginAndPassword(login, password).isPresent()) {
                nextPage = "/Controller?command=homePage";
            } else {
                Account account = DaoProvider.INSTANCE.getAccountDao().findAccountByLoginAndPassword(login, password).get();
                if (session.getAttribute(ACCOUNT) == null) {
                    session.setAttribute(ACCOUNT, account);
                    LOGGER.log(Level.DEBUG, "add account in session: " + account.getId());
                } else {
                    session.setAttribute(ACCOUNT, account);
                    LOGGER.log(Level.DEBUG, "cheng account in session " + account.getId());
                }
                
                if (ServiceProvider.INSTANCE.getAdminService().findAdminByAccountId(account.getId()).isPresent()) {
                    nextPage = SIGN_IN_ADMIN;
                } else if (ServiceProvider.INSTANCE.getUserService().findUserByAccountId(account.getId()).isPresent()) {
                    nextPage = SIGN_IN_USER;
                }
            }
        } catch (ServiceException | DaoException e) {
            LOGGER.log(Level.ERROR, e.getMessage(), e);
        }

        resp.sendRedirect(nextPage);
    }
}
