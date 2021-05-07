package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.SubscriptionDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static final String GET_ALL_USER_SUBSCRIPTION = "select s.id, s.start_date, " +
            "s.end_date, s.user_id, " +
            "s.tariff_plan_id " +
            "from user_subscription s " +
            "inner join user u on u.id = s.user_id " +
            "inner join tariff_plan t on  t.id = s.tariff_plan_id " +
            "where s.user_id = ?";
    private static final String CREATE_SUBSCRIPTION = "insert into user_subscription " +
            "(start_date, user_id, tariff_plan_id) " +
            "VALUES (?, ?, ?)";
    /***TODO
     * update user status
     * */
    private static final String UPDATE_SUBSCRIPTION = "update  set  where login = ?";
    private static final String DELETE_SUBSCRIPTION = "delete from user where id = ?";

    SubscriptionDaoImpl() {
    }

    /**TODO
     * cheng list for return user subscription
     * */
    @Override
    public List<Subscription> getAllUserSubscription(Long userId) throws DaoException {
        List<Subscription> subscriptions = new ArrayList<Subscription>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_USER_SUBSCRIPTION)) {
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
    public Optional<Subscription> findUserSubscriptionById(int subscriptionId) throws DaoException {
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

    }

    @Override
    public void updateSubscription(Subscription subscription) throws DaoException {

    }

    @Override
    public void deleteSubscription(Subscription subscription) throws DaoException {

    }
}
