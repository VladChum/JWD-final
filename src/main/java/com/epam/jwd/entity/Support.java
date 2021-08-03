package com.epam.jwd.entity;

import java.util.Objects;

public class Support extends AbstractBaseEntity {
    private Long accountId;
    private String name;

    public Support(Long id, Long accountId, String name) {
        super(id);
        this.accountId = accountId;
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Support support = (Support) obj;
        return Objects.equals(accountId, support.accountId)
                && Objects.equals(name, support.name);
    }

    @Override
    public String toString() {
        return "Support{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                '}';
    }
}
