package com.epam.jwd.controller.command.impl.admin;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.Discount;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.DiscountService;
import com.epam.jwd.service.impl.ServiceProvider;
import com.epam.jwd.service.validator.Validator;
import com.epam.jwd.service.validator.impl.ValidatorProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UpdateDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(UpdateDiscount.class);

    private static final String DISCOUNT_ID = "discountId";
    private static final String DISCOUNT_SIZE = "discountSize";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";

    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();
    private final Validator dateValidator = ValidatorProvider.INSTANCE.getDateValidator();
    private final Validator numberValidator = ValidatorProvider.INSTANCE.getNumberValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long discountId = Long.valueOf(req.getParameter(DISCOUNT_ID));
        Date newStartDate = java.sql.Date.valueOf(req.getParameter(START_DATE));
        Date newEndDate = java.sql.Date.valueOf(req.getParameter(END_DATE));

        double newDiscountSize = Double.parseDouble(req.getParameter(DISCOUNT_SIZE));

        try {
            if (dateValidator.isValid(newStartDate.toString()) && dateValidator.isValid(newEndDate.toString())
                    && numberValidator.isValid(String.valueOf(newDiscountSize)) && newDiscountSize < 100
                    && discountService.findById(discountId).isPresent()) {
                Discount discount = discountService.findById(discountId).get();
                discount.setStartDate(newStartDate);
                discount.setEndDate(newEndDate);
                discount.setSize(newDiscountSize);
                discountService.update(discount);
            } else {
                resp.getWriter().write("Incorrect date or discount size!");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
