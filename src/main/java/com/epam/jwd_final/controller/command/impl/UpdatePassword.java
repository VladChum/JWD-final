package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePassword implements Command {
    private static final Logger LOGGER = Logger.getLogger(UpdatePassword.class);

    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    private final String ACCOUNT_ID = "accountId";
    private final String PASSWORD = "password";
    private final String NEW_PASSWORD = "newPassword";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long accountId = Long.valueOf(req.getParameter(ACCOUNT_ID));
        String password = req.getParameter(PASSWORD);
        String newPassword = req.getParameter(NEW_PASSWORD);

        try {
            Account account = accountService.findAccountById(accountId).get();
            if (account.getPassword().equals(password)) {
                accountService.updatePassword(accountId, newPassword);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
