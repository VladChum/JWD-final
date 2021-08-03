package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AdminService;
import com.epam.jwd.service.impl.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAdmin implements Command {
    private static final Logger LOGGER = Logger.getLogger(DeleteAdmin.class);

    private static final String ADMIN_ID = "adminId";

    private final AdminService adminService = ServiceProvider.INSTANCE.getAdminService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long adminId = Long.valueOf(req.getParameter(ADMIN_ID));

        try {
            adminService.delete(adminId);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
