package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage implements Command {

    private final String HOME_PAGE = "/home.jsp";
    public HomePage() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.sendRedirect(HOME_PAGE);
    }
}
