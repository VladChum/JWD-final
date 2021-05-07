package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.service.UserService;
import com.epam.jwd_final.service.impl.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPage implements Command {
    private final String USER_PAGE = "/WEB-INF/jsp/user.jsp";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
