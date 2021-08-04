package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Status;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.UserService;
import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindUserByCriteria implements Command {
    private static final Logger LOGGER = Logger.getLogger(FindUserByCriteria.class);

    private static final String LOGIN = "login";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String STATUS_ID= "statusId";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String phone = req.getParameter(PHONE);
        String email = req.getParameter(EMAIL);
        Status status = null;
        Long accountId = null;
        if (login.length() == 0) { login = null; }
        if (firstName.length() == 0) { firstName = null; }
        if (lastName.length() == 0) { lastName = null; }
        if (phone.length() == 0) { phone = null; }
        if (email.length() == 0) { email = null; }

        try {
            if (login != null) {
                if (accountService.checkExistence(login) && accountService.findAccountByLogin(login).isPresent()) {
                    accountId = accountService.findAccountByLogin(login).get().getId();
                } else {
                    accountId = 0L;
                }
            }
            if (!req.getParameter(STATUS_ID).equals("") && req.getParameter(STATUS_ID) != null) {
                status = Status.resolveStatusById(Integer.parseInt(req.getParameter(STATUS_ID)));
            }
            User user = new User(accountId, firstName, lastName, phone, email, status);
            List<User> findUsers = userService.findUserByCriteria(user);

            String json = new Gson().toJson(findUsers);

            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
