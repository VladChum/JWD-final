package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.TariffPlan;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.TariffService;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTariffsToDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(AddTariffsToDiscount.class);

    private static final String DISCOUNT_ID = "discountId";
    private static final String TARIFFS = "tariffs";

    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long discountId = Long.valueOf(req.getParameter(DISCOUNT_ID));
        String[] tariffsString = req.getParameterValues(TARIFFS);
        String[] tariffs = tariffsString[0].split(",");

        try {
            for (String tariff : tariffs) {
                int tariffId = Integer.parseInt(tariff);
                TariffPlan tariffPlan = tariffService.findById(tariffId);
                tariffService.updateTariffDiscount(tariffPlan, discountId);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
