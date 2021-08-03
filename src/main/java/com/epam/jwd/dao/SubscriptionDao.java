package com.epam.jwd.dao;

import com.epam.jwd.entity.Subscription;
import com.epam.jwd.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface SubscriptionDao {
    /**
     * Find subscription in db
     *
     * @param subscriptionId - subscription id
     * @return subscription
     */
    Optional<Subscription> findById(int subscriptionId) throws DaoException;

    /**
     * Find all user subscription by user id
     *
     * @param userId - user id
     * @return list of subscriptions
     */
    List<Subscription> findAllUserSubscription(Long userId) throws DaoException;

    /**
     * Add new subscription in da
     *
     * @param subscription - new subscription
     */
    void createSubscription(Subscription subscription) throws DaoException;

    /**
     * Update subscription data
     *
     * @param subscription - subscription with new data
     */
    void updateSubscription(Subscription subscription) throws DaoException;
}
