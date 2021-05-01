package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage implements Command {

    public HomePage() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("HOME Page");
        resp.sendRedirect("/home.jsp");
    }
}
