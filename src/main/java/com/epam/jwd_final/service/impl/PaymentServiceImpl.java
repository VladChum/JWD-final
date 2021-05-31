package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.PaymentDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.PaymentType;
import com.epam.jwd_final.entity.UserPayment;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.PaymentService;
import com.epam.jwd_final.service.ServiceProvider;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao = DaoProvider.INSTANCE.getPaymentDao();

    @Override
    public void topUpUserBalance(BigDecimal amount, Long userId, Long paymentTypeId) throws ServiceException {
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
    }

    @Override
    public List<UserPayment> findAllUserPayments(Long userId) throws ServiceException {
        try {
            return paymentDao.findAllUserPayment(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
