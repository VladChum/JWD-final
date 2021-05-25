package com.epam.jwd_final;

import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.dao.impl.TariffPlanDaoImpl;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.ServiceProvider;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) throws DaoException, ConnectionPoolException, ServiceException {
//        String login = "admin";
//        String password = "admin";
//
//
//        try {
//            if (!ServiceProvider.INSTANCE.getAccountService().findAccountByLogin(login, password).isPresent()) {
//                System.out.println("no");
//            } else {
//                Account account = DaoProvider.INSTANCE.getAccountDao().findAccountByLogin(login, password).get();
//                if (DaoProvider.INSTANCE.getAdminDao().findAdminById(account.getId().intValue()).isPresent()) {
//                    System.out.println("admin");
//                } else if (DaoProvider.INSTANCE.getUserDao().findUserById(account.getId().intValue()).isPresent()) {
//                    System.out.println("user");
//                }
//            }
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.print(ServiceProvider.INSTANCE.getSubscriptionService().findAllUserSubscription(6L).toString());
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        List<Subscription> subscription = ServiceProvider.INSTANCE.getSubscriptionService().findAllUserSubscription(1L);
//        for (int i = 0; i < subscription.size(); i++) {
//            System.out.println(subscription.get(i).toString());
//        }
//        DaoProvider.INSTANCE.getTariffPlanDao().deleteTariff(2L);
    }
}
