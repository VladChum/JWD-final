package com.epam.jwd.entity;

import java.util.Objects;

public class Account extends AbstractBaseEntity {
    private String login;
    private String password;

    public Account(Long id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;
        return Objects.equals(login, account.login)
                && Objects.equals(password, account.password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
