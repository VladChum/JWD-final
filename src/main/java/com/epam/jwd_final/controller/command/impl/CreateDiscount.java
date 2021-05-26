package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.service.DiscountService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDiscount implements Command {
    private static final Logger LOGGER = Logger.getLogger(CreateDiscount.class);

    private final DiscountService discountService = ServiceProvider.INSTANCE.getDiscountService();

    private final String SIZE = "size";
    private final String START_DATE = "startDate";
    private final String END_DATE = "endDate";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        double size = Double.parseDouble(req.getParameter(SIZE));
        Date startDate =  req.getParameter(START_DATE);
        Date endDate = req.getParameter(END_DATE);
    }
}
