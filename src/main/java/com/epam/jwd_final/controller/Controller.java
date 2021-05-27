package com.epam.jwd_final.controller;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.controller.command.CommandProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller/*")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("command");
        LOGGER.log(Level.DEBUG, "command name: " + name);
        Command command = CommandProvider.INSTANCE.getCommand(name);
        command.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("command");
        LOGGER.log(Level.DEBUG, "command name: " + name);
        Command command = CommandProvider.INSTANCE.getCommand(name);
        command.execute(req, resp);
    }


}
