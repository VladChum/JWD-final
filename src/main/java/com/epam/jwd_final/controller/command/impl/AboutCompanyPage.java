package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutCompanyPage implements Command {

    public AboutCompanyPage() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/aboutCompany.jsp");
    }
}
