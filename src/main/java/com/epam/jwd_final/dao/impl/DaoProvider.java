package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.UserDao;

public enum DaoProvider {
    INSTANCE;

    private final AccountDao accountDao = new AccountDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
