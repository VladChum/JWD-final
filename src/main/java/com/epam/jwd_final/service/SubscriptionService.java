package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    Optional<Subscription> findById(Long id) throws ServiceException;
    Subscription findActiveUserSubscription(Long userId) throws ServiceException;
    List<Subscription> findAllUserSubscription(Long userId) throws ServiceException;
    void stopActiveSubscription(Long userId, Long tariffId) throws ServiceException;
    void newSubscription(Long userId, Long newTariffId) throws ServiceException;
}
