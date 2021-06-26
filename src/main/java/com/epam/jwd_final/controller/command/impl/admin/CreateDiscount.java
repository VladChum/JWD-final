package com.epam.jwd_final.controller.command.impl.admin;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.DiscountService;
import com.epam.jwd_final.service.ServiceProvider;
import com.epam.jwd_final.service.validator.Validator;
import com.epam.jwd_final.service.validator.ValidatorProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreateDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(CreateDiscount.class);

    private static final String SIZE = "size";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";

    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();
    private final Validator dateValidator = ValidatorProvider.INSTANCE.getDateValidator();
    private final Validator numberValidator = ValidatorProvider.INSTANCE.getNumberValidator();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        double size = Double.parseDouble(req.getParameter(SIZE));

        try {
            Date startDate = java.sql.Date.valueOf(req.getParameter(START_DATE));
            Date endDate = java.sql.Date.valueOf(req.getParameter(END_DATE));
            Discount discount = new Discount(startDate, endDate, size);
            if (dateValidator.isValid(startDate.toString()) && dateValidator.isValid(endDate.toString())
                    && numberValidator.isValid(String.valueOf(size)) && size < 100) {
                discountService.create(discount);
            } else {
                resp.getWriter().write("Incorrect date or discount size!");
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
