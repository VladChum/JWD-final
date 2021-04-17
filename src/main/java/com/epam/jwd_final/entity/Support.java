package com.epam.jwd_final.entity;

public class Support extends AbstractBaseEntity {
    private Account account;
    private String name;

    public Support(Account account, String name) {
        super();
        this.account = account;
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
