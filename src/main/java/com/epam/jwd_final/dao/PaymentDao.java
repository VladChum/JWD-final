package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.UserPayment;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;

public interface PaymentDao {
    void topUpUserBalance(UserPayment userPayment) throws DaoException;

    List<UserPayment> findAllUserPayment(Long userId) throws DaoException;

    List<UserPayment> findAllPayments() throws DaoException;
}
