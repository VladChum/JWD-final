package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage implements Command {

    public HomePage() {
        System.out.println("home Page");
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("HOME Page");
    }
}
