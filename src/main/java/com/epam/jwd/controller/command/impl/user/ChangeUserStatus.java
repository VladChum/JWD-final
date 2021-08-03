package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserStatus implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeUserStatus.class);

    private static final String USER_ID = "userId";
    private static final String STATUS_ID = "statusId";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));
        Long statusId = Long.valueOf(req.getParameter(STATUS_ID));

        try {
            User user = userService.findUserById(userId).get();
            userService.changeStatus(user, statusId);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage() + " " + e);
        }
    }
}
