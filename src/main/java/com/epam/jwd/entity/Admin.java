package com.epam.jwd.entity;

import java.util.Objects;

public class Admin extends AbstractBaseEntity {
    private Long accountId;

    public Admin(Long id, Long accountId) {
        super(id);
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Admin admin = (Admin) obj;
        return Objects.equals(accountId, admin.accountId);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "accountId=" + accountId +
                '}';
    }
}
