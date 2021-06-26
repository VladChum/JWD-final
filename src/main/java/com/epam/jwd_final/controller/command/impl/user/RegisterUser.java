package com.epam.jwd_final.controller.command.impl.user;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterUser implements Command {
    private static final Logger LOGGER = Logger.getLogger(RegisterUser.class);

    private static final String SIGN_IN_USER = "/Controller?command=userPage";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String USER = "user";
    private static final String ACCOUNT = "account";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String firstNme = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String phone = req.getParameter(PHONE);
        String email = req.getParameter(EMAIL);
        HttpSession session = req.getSession();

        try {
            if (!accountService.checkExistence(login)) {
                Long accountId = accountService.addAccount(login, password);
                Account account = accountService.findAccountById(accountId).get();
                User user = new User(accountId, firstNme, lastName, phone, email, Status.SUSPENDED);
                userService.addUser(user);
                session.setAttribute(ACCOUNT, account);
                session.setAttribute(USER, userService.findUserByAccountId(account.getId()).get().getAccountId());
                resp.sendRedirect(SIGN_IN_USER);
            } else {
                resp.getWriter().write("false");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
