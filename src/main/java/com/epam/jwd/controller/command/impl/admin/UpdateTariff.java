package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.TariffPlan;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.TariffService;
import com.epam.jwd.service.validator.Validator;
import com.epam.jwd.service.validator.impl.ValidatorProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class UpdateTariff implements Command {
    private static final Logger LOGGER = Logger.getLogger(UpdateTariff.class);

    private static final String TARIFF_ID = "tariffId";
    private static final String TARIFF_NAME = "name";
    private static final String PRICE = "price";
    private static final String SPEED = "speed";

    private final TariffService tariffService = ServiceProvider.INSTANCE.getTariffService();
    private final Validator priceValidator = ValidatorProvider.INSTANCE.getPriceValidator();
    private final Validator speedValidator = ValidatorProvider.INSTANCE.getSpeedValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long tariffId = Long.valueOf(req.getParameter(TARIFF_ID));
        String tariffName = req.getParameter(TARIFF_NAME);
        BigDecimal price = new BigDecimal(req.getParameter(PRICE));
        int speed = Integer.parseInt(req.getParameter(SPEED));

        try {
            if (priceValidator.isValid(price.toString()) && speedValidator.isValid(String.valueOf(speed))
                    && !tariffService.checkExistenceForUpdate(tariffId, tariffName)) {
                TariffPlan tariffPlan = tariffService.findById(tariffId.intValue());
                tariffPlan.setName(tariffName);
                tariffPlan.setPrice(price);
                tariffPlan.setSpeed(speed);
                tariffService.updateTariff(tariffPlan);
            } else {
                resp.getWriter().write("Incorrect data or tariff with this NAME exist!");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
