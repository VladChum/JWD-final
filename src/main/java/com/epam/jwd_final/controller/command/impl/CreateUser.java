package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUser implements Command {
    private static final Logger LOGGER = Logger.getLogger(CreateUser.class);

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final AccountService accountService = ServiceProvider.INSTANCE.getAccountService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    }
}
