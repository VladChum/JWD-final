package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOut implements Command {
    private final String HOME_PAGE = "/Controller?command=homePage";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session != null) {
            session.invalidate();
        }

        resp.sendRedirect(HOME_PAGE);
    }
}
