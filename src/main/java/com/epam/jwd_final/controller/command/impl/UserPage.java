package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.UserService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(UserPage.class);

    private final String USER_PAGE = "/WEB-INF/jsp/user.jsp";
    private final String USER = "user";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession();
            User user = userService.findUserById((Long) session.getAttribute(USER)).get();
            req.setAttribute(USER, user);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
