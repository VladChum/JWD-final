package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Status;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUser implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUser.class);

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";

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

        try {
            if (!accountService.checkExistence(login)) {
                Long accountId = accountService.addAccount(login, password);
                User user = new User(accountId, firstNme, lastName, phone, email, Status.ACTIVATE);
                userService.addUser(user);
            } else {
                resp.getWriter().write("false");
            }
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage() + " " + e);
        }
    }
}
