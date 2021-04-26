package com.epam.jwd_final.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class UserPayment extends AbstractBaseEntity{
    private Date date;
    private BigDecimal amount;
    private Long userId;
    private PaymentType paymentType;

    public UserPayment(Long id, Date date, BigDecimal amount, Long userId, PaymentType paymentType) {
        super(id);
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, userId, paymentType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UserPayment userPayment = (UserPayment) obj;
        return Objects.equals(date, userPayment.date)
                && Objects.equals(amount, userPayment.amount)
                && Objects.equals(userId, userPayment.userId)
                && Objects.equals(paymentType, userPayment.paymentType);
    }

    @Override
    public String toString() {
        return "UserPayment{" +
                "date=" + date +
                ", amount=" + amount +
                ", userId=" + userId +
                ", paymentType=" + paymentType +
                '}';
    }
}
