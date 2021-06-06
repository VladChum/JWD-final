package com.epam.jwd_final.controller.command.impl.page;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginPage implements Command {
    private final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
    private final String SIGN_IN_USER = "/Controller?command=userPage";
    private final String USER = "user";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();

        if (httpSession.getAttribute(USER) != null) {
            resp.sendRedirect(SIGN_IN_USER);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(LOGIN_PAGE);
            requestDispatcher.forward(req, resp);
        }
    }
}
