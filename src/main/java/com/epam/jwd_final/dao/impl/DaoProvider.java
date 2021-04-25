package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.*;

public enum DaoProvider {
    INSTANCE;

    private final AccountDao accountDao = new AccountDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();
    private final TariffPlanDao tariffPlanDao = new TariffPlanDaoImpl();
    private final SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AdminDao getAdminDao() {return adminDao;}

    public TariffPlanDao getTariffPlanDao() {return tariffPlanDao;}

    public SubscriptionDao getSubscriptionDao() {return subscriptionDao;}
}
