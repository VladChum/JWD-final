package com.epam.jwd_final.controller.command.impl.page;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorPage implements Command {
    private static final String ERROR_PAGE = "/WEB-INF/jsp/404.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ERROR_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
