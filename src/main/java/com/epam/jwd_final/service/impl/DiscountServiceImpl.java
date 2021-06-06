package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.DiscountDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.entity.Subscription;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.DiscountService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountDao discountDao = DaoProvider.INSTANCE.getDiscountDao();

    @Override
    public List<Discount> findAll() throws ServiceException {
        try {
            return discountDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void create(Discount discount) throws ServiceException {
        try {
            discountDao.create(discount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Discount> findById(Long id) throws ServiceException {
        try {
            return discountDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void stopDiscountById(Long id) throws ServiceException {
        try {
            Discount discount = findById(id).get();
            Date startDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            discount.setEndDate(java.sql.Date.valueOf(dateFormat.format(startDate)));
            discountDao.stopDiscount(discount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Discount discount) throws ServiceException {
        try {
            discountDao.updateDiscount(discount);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkActiveDiscount(Discount discount) throws ServiceException {
        boolean result = false;

        Date startDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (discount.getStartDate().compareTo(java.sql.Date.valueOf(dateFormat.format(startDate))) <= 0
                && discount.getEndDate().compareTo(java.sql.Date.valueOf(dateFormat.format(startDate))) >= 0) {
            result = true;
        }
        return result;
    }
}
