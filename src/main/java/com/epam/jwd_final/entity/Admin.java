package com.epam.jwd_final.entity;

public class Admin extends AbstractBaseEntity {
    private Account account;

    public Admin(Account account) {
        super();
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
