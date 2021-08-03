package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.SubscriptionDao;
import com.epam.jwd.dao.connection.ConnectionPool;
import com.epam.jwd.entity.Subscription;
import com.epam.jwd.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubscriptionDaoImpl implements SubscriptionDao {
    private static final String FIND_SUBSCRIPTION_BY_ID = "select s.id, s.start_date, " +
            "s.end_date, s.user_id, " +
            "s.tariff_plan_id " +
            "from user_subscription s " +
            "inner join user u on u.id = s.user_id " +
            "inner join tariff_plan t on  t.id = s.tariff_plan_id " +
            "where s.id = ?";
    private static final String FIND_ALL_USER_SUBSCRIPTION = "select s.id, s.start_date, " +
            "s.end_date, s.user_id, " +
            "s.tariff_plan_id " +
            "from user_subscription s " +
            "inner join user u on u.id = s.user_id " +
            "inner join tariff_plan t on  t.id = s.tariff_plan_id " +
            "where s.user_id = ?";
    private static final String CREATE_SUBSCRIPTION = "insert into user_subscription " +
            "(start_date, user_id, tariff_plan_id) " +
            "VALUES (?, ?, ?)";
    private static final String UPDATE_SUBSCRIPTION = "update user_subscription set end_date = ? where id = ?";

    SubscriptionDaoImpl() {
    }

    @Override
    public List<Subscription> findAllUserSubscription(Long userId) throws DaoException {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_USER_SUBSCRIPTION)) {
            prepareStatement.setInt(1, userId.intValue());
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Subscription subscription = new Subscription(
                            resultSet.getLong("id"),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getLong(4),
                            resultSet.getLong(5));
                    subscriptions.add(subscription);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return subscriptions;
    }

    @Override
    public Optional<Subscription> findById(int subscriptionId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_SUBSCRIPTION_BY_ID)) {
            prepareStatement.setInt(1, subscriptionId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Subscription(resultSet.getLong("id"),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getLong(4),
                            resultSet.getLong(5)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public void createSubscription(Subscription subscription) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SUBSCRIPTION)) {
            preparedStatement.setDate(1, Date.valueOf(String.valueOf(subscription.getStartDate())));
            preparedStatement.setInt(2, subscription.getUserId().intValue());
            preparedStatement.setInt(3, subscription.getTariffPlanId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateSubscription(Subscription subscription) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SUBSCRIPTION)) {
            preparedStatement.setDate(1, Date.valueOf(String.valueOf(subscription.getEndDate())));
            preparedStatement.setInt(2, subscription.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


}
