package com.epam.jwd_final.service;

import com.epam.jwd_final.service.impl.AccountServiceImpl;

public enum ServiceProvider {
    INSTANCE;

   private final AccountService accountService = new AccountServiceImpl();

    public AccountService getAccountService() {
        return accountService;
    }
}
