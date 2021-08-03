package com.epam.jwd.entity;

import com.epam.jwd.exception.UnknownEntityException;

import java.util.Arrays;

public enum PaymentType {
    BALANCE(1L),
    CREDIT_CARD(2L),
    PROMISED_PAYMENT(3L);

    private final Long id;

    PaymentType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name();
    }

    public static PaymentType resolvePaymentTypeById(int id) throws UnknownEntityException {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.id.equals((long) id))
                .findFirst()
                .orElseThrow(() -> new UnknownEntityException("Impossible to resolve status by specified id"));
    }
}
