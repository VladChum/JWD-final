package com.epam.jwd_final.service.daily_payment;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.TriggerBuilder.newTrigger;

public class DailyPaymentServlet implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(DailyPaymentServlet.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler =schedulerFactory.getScheduler();
            JobDetail job = JobBuilder.newJob(DailyPayment.class)
                    .withIdentity("myJob", "group1")
                    .build();
            Trigger trigger = newTrigger()
                    .withIdentity("trigger3", "group1")
                    .startNow()
                    .withSchedule(dailyAtHourAndMinute(0, 0)) //  every day at 00:00
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        LOGGER.log(Level.INFO, "start daily payment");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.INFO, "stop daily payment");
    }

}
