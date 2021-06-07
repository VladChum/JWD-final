package com.epam.jwd_final;

import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.ServiceProvider;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


public class Main {
    public static void main(String[] args) throws DaoException, ConnectionPoolException, ServiceException {
//        ServiceProvider.INSTANCE.getPaymentService().dailyPaymentForAllUser();
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        try {
//            Scheduler scheduler =schedulerFactory.getScheduler();
//            JobDetail job = JobBuilder.newJob(DailyPayment.class)
//                    .withIdentity("myJob", "group1")
//                    .build();
//            Trigger trigger = newTrigger()
//                    .withIdentity("trigger3", "group1")
//                    .startNow()
//                    .withSchedule(dailyAtHourAndMinute(0, 0)) // fire every day at 00:00
//                    .build();
//            scheduler.scheduleJob(job, trigger);
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }
}
