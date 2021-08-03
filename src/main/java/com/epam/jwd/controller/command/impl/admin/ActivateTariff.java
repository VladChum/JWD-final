package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.TariffService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActivateTariff implements Command {
    private static final Logger LOGGER = Logger.getLogger(ActivateTariff.class);

    private static final String TARIFF_ID = "tariffId";

    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long tariffId = Long.valueOf(req.getParameter(TARIFF_ID));

        try {
            tariffService.activateTariff(tariffId);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
