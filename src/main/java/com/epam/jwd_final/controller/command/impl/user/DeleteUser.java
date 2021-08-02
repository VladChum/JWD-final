package com.epam.jwd_final.controller.command.impl.user;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.controller.command.impl.admin.DeleteAdmin;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.impl.ServiceProvider;
import com.epam.jwd_final.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteAdmin.class);

    private static final String USER_ID = "userId";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));

        try {
            userService.delete(userId);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage() + " " + e);
        }
    }
}
