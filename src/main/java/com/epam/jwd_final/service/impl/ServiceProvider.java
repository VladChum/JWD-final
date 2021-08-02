package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.service.*;
import com.epam.jwd_final.service.impl.*;

public enum ServiceProvider {
    INSTANCE;

   private final AccountService accountService = new AccountServiceImpl();
   private final AdminService adminService = new AdminServiceImpl();
   private final UserService userService = new UserServiceImpl();
   private final TariffService tariffService = new TariffServiceImpl();
   private final SubscriptionService subscriptionService = new SubscriptionServiceImpl();
   private final DiscountService discountService = new DiscountServiceImpl();
   private final PaymentService paymentService = new PaymentServiceImpl();

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

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}
