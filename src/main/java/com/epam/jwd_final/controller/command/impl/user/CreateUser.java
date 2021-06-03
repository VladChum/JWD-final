package com.epam.jwd_final.controller.command.impl.user;

import com.epam.jwd_final.controller.command.Command;
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
import java.io.IOException;

public class CreateUser implements Command {
    private static final Logger LOGGER = Logger.getLogger(CreateUser.class);

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String PHONE = "phone";
    private final String EMAIL = "email";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String firstNme = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String phone = req.getParameter(PHONE);
        String email = req.getParameter(EMAIL);

        try {
            /**ToDo
             * make status suspended where create user
             * */
            Long accountId = accountService.addAccount(login, password);
            User user = new User(accountId, firstNme, lastName, phone, email, Status.ACTIVATE);
            userService.addUser(user);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
