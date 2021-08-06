package com.epam.jwd.dao;

import com.epam.jwd.entity.UserPayment;
import com.epam.jwd.exception.DaoException;

import java.util.List;

public interface PaymentDao {
    /**
     * Update user balance in db
     *
     * @param userPayment - user payment with new balance
     */
    void topUpUserBalance(UserPayment userPayment) throws DaoException;

    /**
     * Find all user payments by user id
     *
     * @param userId - user id
     * @return list user payments
     */
    List<UserPayment> findAllUserPayment(Long userId) throws DaoException;

    /**
     * Find all payments in db
     *
     * @return list user payments
     */
    List<UserPayment> findAllPayments() throws DaoException;
}
