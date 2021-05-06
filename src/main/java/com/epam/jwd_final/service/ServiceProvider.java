package com.epam.jwd_final.service;

import com.epam.jwd_final.service.impl.AccountServiceImpl;
import com.epam.jwd_final.service.impl.AdminServiceImpl;
import com.epam.jwd_final.service.impl.UserServiceImpl;

public enum ServiceProvider {
    INSTANCE;

   private final AccountService accountService = new AccountServiceImpl();
   private final AdminService adminService = new AdminServiceImpl();
   private final UserService userService = new UserServiceImpl();

    public AccountService getAccountService() {
        return accountService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public UserService getUserService() {
        return userService;
    }
}
