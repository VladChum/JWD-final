package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.PaymentService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class Payment implements Command {
    private static final Logger LOGGER = Logger.getLogger(Payment.class);

    private final PaymentService paymentService = ServiceProvider.INSTANCE.getPaymentService();

    private final String USER_ID = "userId";
    private final String AMOUNT = "amount";
    private final String PAYMENT_TYPE = "paymentType";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(req.getParameter(AMOUNT)));
        Long paymentType = Long.valueOf(req.getParameter(PAYMENT_TYPE));
        try {
            paymentService.topUpUserBalance(amount, userId, paymentType);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
