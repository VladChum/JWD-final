package com.epam.jwd_final.controller.command.impl.admin;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.TariffService;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTariffsToDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(AddTariffsToDiscount.class);

    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();

    private final String DISCOUNT_ID = "discountId";
    private final String TARIFFS = "tariffs";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long discountId = Long.valueOf(req.getParameter(DISCOUNT_ID));
        String[] tariffsString = req.getParameterValues(TARIFFS);
        String[] tariffs = tariffsString[0].split(",");

        try {
            for (int i = 0; i < tariffs.length; i++) {
                int tariffId = Integer.parseInt(tariffs[i]);
                TariffPlan tariffPlan = tariffService.findById(tariffId);
                tariffService.updateTariffDiscount(tariffPlan, discountId);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
