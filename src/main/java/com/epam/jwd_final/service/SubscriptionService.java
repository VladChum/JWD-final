package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    /**
     * Find subscription in db by id
     *
     * @param id - subscription id
     * @return subscription
     */
    Optional<Subscription> findById(Long id) throws ServiceException;

    /**
     * Find active user subscription in db by user id
     *
     * @param userId - user id
     * @return active user subscription ro return null
     */
    Subscription findActiveUserSubscription(Long userId) throws ServiceException;

    /**
     * Find all user subscriptions by id
     *
     * @param userId - user id
     * @return list user subscriptions
     */
    List<Subscription> findAllUserSubscription(Long userId) throws ServiceException;

    /**
     * Stops active user subscription, change end date for subscription
     *
     * @param userId   - user id
     * @param tariffId - tariff id
     */
    void stopActiveSubscription(Long userId, Long tariffId) throws ServiceException;

    /**
     * Create new subscription and add in db
     *
     * @param userId      - user id
     * @param newTariffId - tariff id
     */
    void newSubscription(Long userId, Long newTariffId) throws ServiceException;
}
