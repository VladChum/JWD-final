package com.epam.jwd.controller.command.impl.user;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.entity.PaymentType;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.PaymentService;
import com.epam.jwd.service.impl.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class Payment implements Command {
    private static final Logger LOGGER = Logger.getLogger(Payment.class);
    private static final String USER_ID = "userId";
    private static final String AMOUNT = "amount";
    private static final String PAYMENT_TYPE = "paymentType";

    private final PaymentService paymentService = ServiceProvider.INSTANCE.getPaymentService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long userId = Long.valueOf(req.getParameter(USER_ID));
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(req.getParameter(AMOUNT)));
        Long paymentType = Long.valueOf(req.getParameter(PAYMENT_TYPE));

        try {
            if (paymentType.equals(PaymentType.PROMISED_PAYMENT.getId()) && paymentService.checkActivePromisedPayment(userId)) {
                resp.getWriter().write("*Sorry you have active promisedPayment");
            } else {
                paymentService.topUpUserBalance(amount, userId, paymentType);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
        }
    }
}
