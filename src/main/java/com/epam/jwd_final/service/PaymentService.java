package com.epam.jwd_final.service;

import com.epam.jwd_final.exception.ServiceException;

import java.math.BigDecimal;

public interface PaymentService {
    void topUpUserBalance(BigDecimal amount, Long userId, Long paymentTypeId) throws ServiceException;


}
