package com.epam.jwd_final;

import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.PaymentService;
import com.epam.jwd_final.service.ServiceProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DailyPayment implements Job {
    private static final Logger LOGGER = Logger.getLogger(DailyPayment.class);
    private final PaymentService paymentService = ServiceProvider.INSTANCE.getPaymentService();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            paymentService.dailyPaymentForAllUser();
            LOGGER.log(Level.INFO, "Daily payment made!");
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e.getMessage() + " ", e);
        }
    }
}
