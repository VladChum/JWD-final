package com.epam.jwd_final.entity;

import java.util.Date;

public class UserPayment extends AbstractBaseEntity{
    private Date date;
    private float amount;
    private User userId;
    private PaymentType paymentType;

    public UserPayment(Date date, float amount, User userId, PaymentType paymentType) {
        super();
        this.date = date;
        this.amount = amount;
        this.userId = userId;
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
