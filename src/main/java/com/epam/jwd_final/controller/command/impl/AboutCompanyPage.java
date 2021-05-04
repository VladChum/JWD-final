package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutCompanyPage implements Command {

    private final String ABOUT_COMPANY_PAGE = "/WEB-INF/jsp/aboutCompany.jsp";

    public AboutCompanyPage() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ABOUT_COMPANY_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
