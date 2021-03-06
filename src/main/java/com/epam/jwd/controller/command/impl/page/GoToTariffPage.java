package com.epam.jwd.controller.command.impl.page;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.TariffPlan;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.TariffService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToTariffPage implements Command {
    private static final Logger LOGGER = Logger.getLogger(GoToTariffPage.class);

    private static final String TARIFF_PAGE = "/WEB-INF/jsp/tariff.jsp";
    private static final String TARIFF_PLANS = "tariffPlans";
    
    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            List<TariffPlan> tariffPlans = tariffService.findAllTariff();
            req.setAttribute(TARIFF_PLANS, tariffPlans);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(TARIFF_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
