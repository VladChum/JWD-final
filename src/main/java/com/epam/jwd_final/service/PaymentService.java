package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.UserPayment;
import com.epam.jwd_final.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    void topUpUserBalance(BigDecimal amount, Long userId, Long paymentTypeId) throws ServiceException;

    List<UserPayment> findAllUserPayments(Long userId) throws ServiceException;
}
