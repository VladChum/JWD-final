package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffPage implements Command {
    public TariffPage() {
        System.out.println("tariff page");
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("TARIFF page");

    }
}
