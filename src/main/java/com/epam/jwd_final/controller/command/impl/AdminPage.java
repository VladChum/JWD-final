package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPage implements Command {
    private final String ADMIN_PAGE = "/WEB-INF/jsp/admin.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADMIN_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
