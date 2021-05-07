package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.service.AccountService;
import com.epam.jwd_final.service.AdminService;
import com.epam.jwd_final.service.TariffService;
import com.epam.jwd_final.service.UserService;

public enum ServiceProvider {
    INSTANCE;

   private final AccountService accountService = new AccountServiceImpl();
   private final AdminService adminService = new AdminServiceImpl();
   private final UserService userService = new UserServiceImpl();
   private final TariffService tariffService = new TariffServiceImpl();

    public AccountService getAccountService() {
        return accountService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TariffService getTariffService() {
        return tariffService;
    }
}
