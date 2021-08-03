package com.epam.jwd.dao.impl;


import com.epam.jwd.dao.*;

public enum DaoProvider {
    INSTANCE;

    private final AccountDao accountDao = new AccountDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();
    private final TariffPlanDao tariffPlanDao = new TariffPlanDaoImpl();
    private final SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();
    private final DiscountDao discountDao = new DiscountDaoImpl();
    private final PaymentDao paymentDao = new PaymentDaoImpl();

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AdminDao getAdminDao() {return adminDao;}

    public TariffPlanDao getTariffPlanDao() {return tariffPlanDao;}

    public SubscriptionDao getSubscriptionDao() {return subscriptionDao;}

    public DiscountDao getDiscountDao() {
        return discountDao;
    }

    public PaymentDao getPaymentDao() {
        return paymentDao;
    }
}
