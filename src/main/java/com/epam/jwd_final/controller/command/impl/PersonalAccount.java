package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PersonalAccount implements Command {
    private final String ACCOUNT = "account";
    private final String USER = "user";
    private final String ADMIN = "admin";
    private final String USER_PAGE = "/Controller?command=userPage";
    private final String ADMIN_PAGE = "/Controller?command=adminPage";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        String personalAccount = "";

        if (httpSession != null) {
            Account account = (Account) httpSession.getAttribute(ACCOUNT);
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
