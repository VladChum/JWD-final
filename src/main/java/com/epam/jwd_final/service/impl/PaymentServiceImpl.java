package com.epam.jwd_final.service.impl;

import  com.epam.jwd_final.dao.PaymentDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.*;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao = DaoProvider.INSTANCE.getPaymentDao();

    @Override
    public void topUpUserBalance(BigDecimal amount, Long userId, Long paymentTypeId) throws ServiceException {
        boolean activePromised = checkActivePromisedPayment(userId);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PaymentType paymentType = PaymentType.resolvePaymentTypeById(paymentTypeId.intValue());
        UserPayment userPayment = new UserPayment(java.sql.Date.valueOf(dateFormat.format(date)),
                amount,
                userId,
                paymentType);
        ServiceProvider.INSTANCE.getUserService().updateBalance(userId, amount);
        try {
            paymentDao.topUpUserBalance(userPayment);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        checkEndPromisedPayment(userId, activePromised);
    }

    @Override
    public List<UserPayment> findAllUserPayments(Long userId) throws ServiceException {
        try {
            return paymentDao.findAllUserPayment(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void dailyPaymentForAllUser() throws ServiceException {
        List<User> users = ServiceProvider.INSTANCE.getUserService().findAll();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getStatus() == Status.ACTIVATE) {
                if (user.getBalance().compareTo(BigDecimal.valueOf(0)) >= 0) {
                    Subscription userSubscription = ServiceProvider.INSTANCE.getSubscriptionService().findActiveUserSubscription(user.getId());
                    if (userSubscription != null) {
                        paymentIfSubscriptionActive(userSubscription, user);
                    } else {
                        ServiceProvider.INSTANCE.getUserService().changeStatus(user, 3L);
                    }
                } else {
                    ServiceProvider.INSTANCE.getUserService().changeStatus(user, 2L);
                }
            }
        }
    }

    @Override
    public boolean checkActivePromisedPayment(Long userId) throws ServiceException {
        List<UserPayment> userPayments = findAllUserPayments(userId);
        Collections.reverse(userPayments);
        boolean result = false;

        double amount = 0;
        for (int i = 0; i < userPayments.size(); i++) {
            UserPayment userPayment = userPayments.get(i);
            if (userPayment.getPaymentType() == PaymentType.CREDIT_CARD) {
                amount += userPayment.getAmount().doubleValue();
            } else if (userPayment.getPaymentType() == PaymentType.PROMISED_PAYMENT) {
                if (amount < userPayment.getAmount().doubleValue()) {
                    result = true;
                }
                break;
            }
        }
        return result;
    }

    @Override
    public BigDecimal findLastUserPromisedAmount(Long userId) throws ServiceException {
        double amount = 0;
        List<UserPayment> userPayments = findAllUserPayments(userId);
        Collections.reverse(userPayments);
        for (int i = 0; i < userPayments.size(); i++) {
            UserPayment userPayment = userPayments.get(i);
            if (userPayment.getPaymentType() == PaymentType.PROMISED_PAYMENT) {
                amount = userPayment.getAmount().doubleValue();
                break;
            }
        }

        return BigDecimal.valueOf(amount);
    }

    private void paymentIfSubscriptionActive(Subscription userSubscription, User user) throws ServiceException {
        TariffPlan userTariff = ServiceProvider.INSTANCE.getTariffService().findById(userSubscription.getTariffPlanId().intValue());
        Discount discount = ServiceProvider.INSTANCE.getDiscountService().findById(userTariff.getDiscountId()).get();

        double amount = userTariff.getPrice().doubleValue();
        amount *= -1 / 30.;
        if (ServiceProvider.INSTANCE.getDiscountService().checkActiveDiscount(discount)) {
            amount *= (100 - discount.getSize()) / 100.;
        }
        topUpUserBalance(BigDecimal.valueOf(amount), user.getId(), 1L);
    }

    private void checkEndPromisedPayment(Long userId, boolean startActivePromised) throws ServiceException {
        boolean endActivePromised = checkActivePromisedPayment(userId);
        if (startActivePromised && !endActivePromised) {
            User user = ServiceProvider.INSTANCE.getUserService().findUserById(userId).get();
            ServiceProvider.INSTANCE.getUserService().changeStatus(user, Status.ACTIVATE.getId());
            double amount = findLastUserPromisedAmount(userId).doubleValue() * -1;
            topUpUserBalance(BigDecimal.valueOf(amount), userId, PaymentType.BALANCE.getId());
        }
    }
}
