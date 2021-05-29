package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengUserStatus implements Command {
    private static final Logger LOGGER = Logger.getLogger(ChengUserStatus.class);

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    private final String USER_ID = "userId";
    private final String STATUS_ID = "statusId";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));
        Long statusId = Long.valueOf(req.getParameter(STATUS_ID));

        try {
            User user = userService.findUserById(userId).get();
            userService.chengStatus(user, statusId);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
