package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface SubscriptionDao {
    List<Subscription> getAllUserSubscription(Long userId) throws DaoException;
    Optional<Subscription> findUserSubscriptionById(int subscriptionId) throws DaoException;
    void createSubscription(Subscription subscription) throws DaoException;
    void updateSubscription(Subscription subscription) throws DaoException;
    void deleteSubscription(Subscription subscription) throws DaoException;
}
