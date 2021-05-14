package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface SubscriptionDao {
    Optional<Subscription> findById(int subscriptionId) throws DaoException;
    List<Subscription> findAllUserSubscription(Long userId) throws DaoException;
    void createSubscription(Subscription subscription) throws DaoException;
    void updateSubscription(Subscription subscription) throws DaoException;
    void deleteSubscription(Subscription subscription) throws DaoException;
}
