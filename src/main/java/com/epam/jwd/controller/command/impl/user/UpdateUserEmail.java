package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.UserService;
import com.epam.jwd.service.validator.Validator;
import com.epam.jwd.service.validator.impl.ValidatorProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserEmail implements Command {
    private static final Logger LOGGER = Logger.getLogger(UpdateUserEmail.class);

    private static final String USER_ID = "userId";
    private static final String NEW_EMAIL = "newEmail";

    private final UserService userService = ServiceProvider.INSTANCE.getUserService();
    private final Validator emailValidator = ValidatorProvider.INSTANCE.getEmailValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));
        String newEmail = req.getParameter(NEW_EMAIL);

        try {
            User user = userService.findUserById(userId).get();
            if (!user.getEmail().equals(newEmail) && emailValidator.isValid(newEmail)) {
                userService.updateEmail(userId, newEmail);
            } else {
                resp.getWriter().write("*Incorrect email, example: Sparkl@gmail.com");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
