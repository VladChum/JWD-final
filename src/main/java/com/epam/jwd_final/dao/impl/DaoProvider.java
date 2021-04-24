package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.AdminDao;
import com.epam.jwd_final.dao.UserDao;

public enum DaoProvider {
    INSTANCE;

    private final AccountDao accountDao = new AccountDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AdminDao getAdminDao() {return adminDao;}
}
