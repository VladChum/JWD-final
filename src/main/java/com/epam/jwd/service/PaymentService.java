package com.epam.jwd.service;

import com.epam.jwd.entity.UserPayment;
import com.epam.jwd.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    /**
     * Update user balance
     *
     * @param amount        - top-up amount
     * @param userId        - user id
     * @param paymentTypeId - payment type
     */
    void topUpUserBalance(BigDecimal amount, Long userId, Long paymentTypeId) throws ServiceException;

    /**
     * Find all user payments by user id
     *
     * @param userId - user id
     * @return list all user payments
     */
    List<UserPayment> findAllUserPayments(Long userId) throws ServiceException;

    /**
     * Debits money from the account of each user on a daily basis, taking into account the user's status
     */
    void dailyPaymentForAllUser() throws ServiceException;

    /**
     * Find amount last promised payment  by user id
     *
     * @param userId - user id
     * @return amount last user promised payment or return 0
     */
    BigDecimal findLastUserPromisedAmount(Long userId) throws ServiceException;

    /**
     * Check active promised payment for user
     *
     * @param userId - user id
     * @return result of check
     */
    boolean checkActivePromisedPayment(Long userId) throws ServiceException;
}
