package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.PaymentDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.UserPayment;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    private static final String TOP_UP_USER_BALANCE = "insert into user_payment (date, amount, user_id, payment_type_id) VALUES (?, ?, ?, ?);";
    private static final String FIND_ALL_USER_PAYMENT = "select p.id, p.date, p.amount, p.user_id, p.payment_type_id from user_payment p where user_id = ?;";
    
    PaymentDaoImpl() {
    }

    @Override
    public void topUpUserBalance(UserPayment userPayment) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TOP_UP_USER_BALANCE)) {
            preparedStatement.setDate(1, Date.valueOf(String.valueOf(userPayment.getDate())));
            preparedStatement.setBigDecimal(2, userPayment.getAmount());
            preparedStatement.setInt(3, userPayment.getUserId().intValue());
            preparedStatement.setInt(4, userPayment.getPaymentType().getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<UserPayment> findAllUserPayment(Long userId) throws DaoException {
        return null;
    }
}
