package com.epam.jwd_final.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class User extends AbstractBaseEntity {
    private Long accountId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Status status;
    private BigDecimal balance;

    public User(Long id, Long accountId, String firstName, String lastName,
                String phone, String email, Status status, BigDecimal balance) {
        super(id);
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.balance = balance;
    }

    public User(Long accountId, String firstName, String lastName,
                String phone, String email, Status status) {
        super(0L);
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, firstName, lastName, phone, email, status, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;
        return Objects.equals(accountId, user.accountId)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(phone, user.phone)
                && Objects.equals(email, user.email)
                && Objects.equals(status, user.status)
                && Objects.equals(balance, user.balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
