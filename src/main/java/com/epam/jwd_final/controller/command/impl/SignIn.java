package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignIn implements Command {
    private final String SIGN_IN_USER = "/WEB-INF/jsp/user.jsp";
    private final String SIGN_IN_ADMIN = "/WEB-INF/jsp/admin.jsp";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    public SignIn() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        System.out.println(login);
        System.out.println(password);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(SIGN_IN);
        requestDispatcher.forward(req, resp);
    }
}
