package com.epam.jwd.controller.command.impl;

import com.epam.jwd.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PersonalAccount implements Command {
    private static final String USER = "user";
    private static final String ADMIN = "admin";
    private static final String USER_PAGE = "/Controller?command=userPage";
    private static final String ADMIN_PAGE = "/Controller?command=adminPage";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        String personalAccount = "";

        if (httpSession != null) {
            if (httpSession.getAttribute(USER) != null) {
                personalAccount = USER_PAGE;
            }
            if (httpSession.getAttribute(ADMIN) != null) {
                personalAccount = ADMIN_PAGE;
            }
        }
        resp.sendRedirect(personalAccount);
    }
}
