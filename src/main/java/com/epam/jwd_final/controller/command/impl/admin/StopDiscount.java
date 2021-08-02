package com.epam.jwd_final.controller.command.impl.admin;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.DiscountService;
import com.epam.jwd_final.service.impl.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StopDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(StopDiscount.class);

    private static final String DISCOUNT_ID = "discountId";

    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long discountId = Long.valueOf(req.getParameter(DISCOUNT_ID));

        try {
            discountService.stopDiscountById(discountId);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
