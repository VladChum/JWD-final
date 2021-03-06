package com.epam.jwd.controller.command.impl;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Account;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.validator.Validator;
import com.epam.jwd.service.validator.impl.ValidatorProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePassword implements Command {
    private static final Logger LOGGER = Logger.getLogger(UpdatePassword.class);
    private static final String ACCOUNT_ID = "accountId";
    private static final String PASSWORD = "password";
    private static final String NEW_PASSWORD = "newPassword";

    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();
    private final Validator passwordValidator = ValidatorProvider.INSTANCE.getPasswordValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long accountId = Long.valueOf(req.getParameter(ACCOUNT_ID));
        String password = req.getParameter(PASSWORD);
        String newPassword = req.getParameter(NEW_PASSWORD);

        try {
            if (accountService.findAccountById(accountId).isPresent()) {
                Account account = accountService.findAccountById(accountId).get();
                if (account.getPassword().equals(password) && passwordValidator.isValid(newPassword)) {
                    accountService.updatePassword(accountId, newPassword);
                } else {
                    resp.getWriter().write("Wrong account password!");
                }
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
