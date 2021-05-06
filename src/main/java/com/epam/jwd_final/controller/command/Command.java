package com.epam.jwd_final.controller.command;

import com.epam.jwd_final.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, DaoException;
}
