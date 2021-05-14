package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.SubscriptionDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.SubscriptionService;

import java.util.List;
import java.util.Optional;

public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionDao subscriptionDao = DaoProvider.INSTANCE.getSubscriptionDao();

    @Override
    public Optional<Subscription> findById(Long id) throws ServiceException {
        try {
            return subscriptionDao.findById(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Subscription findActiveUserSubscription(Long userId) throws ServiceException {
        Subscription subscription = null;
        try {
            List<Subscription> subscriptions = subscriptionDao.findAllUserSubscription(userId);
            for (int i = 0; i < subscriptions.size(); i++){
                if (subscriptions.get(i).getEndDate() == null) {
                    subscription = subscriptions.get(i);
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return subscription;
    }

    @Override
    public List<Subscription> findAllUserSubscription(Long userId) throws ServiceException {
        try {
            return subscriptionDao.findAllUserSubscription(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
