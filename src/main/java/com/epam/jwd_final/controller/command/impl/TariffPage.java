package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.impl.ServiceProvider;
import com.epam.jwd_final.service.TariffService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TariffPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(TariffPage.class);

    private static final String TARIFF_PAGE = "/WEB-INF/jsp/tariff.jsp";
    private static final String TARIFF_PLANS = "tariffPlans";
    
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            List<TariffPlan> tariffPlans = tariffService.getAllTariff();
            req.setAttribute(TARIFF_PLANS, tariffPlans);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(TARIFF_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
