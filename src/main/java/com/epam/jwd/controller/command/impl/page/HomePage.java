package com.epam.jwd.controller.command.impl.page;

import com.epam.jwd.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage implements Command {
    private static final String HOME_PAGE = "/WEB-INF/jsp/home.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(HOME_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
