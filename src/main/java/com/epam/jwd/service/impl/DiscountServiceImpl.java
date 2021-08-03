package com.epam.jwd.service.impl;

import com.epam.jwd.dao.DiscountDao;
import com.epam.jwd.dao.impl.DaoProvider;
import com.epam.jwd.entity.Discount;
import com.epam.jwd.exception.DaoException;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.DiscountService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountDao discountDao = DaoProvider.INSTANCE.getDiscountDao();

    DiscountServiceImpl() {

    }

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

    @Override
    public boolean checkPlanedDiscount(Discount discount) throws ServiceException {
        boolean result = false;

        Date startDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (discount.getStartDate().compareTo(java.sql.Date.valueOf(dateFormat.format(startDate))) >= 0
                && discount.getEndDate().compareTo(java.sql.Date.valueOf(dateFormat.format(startDate))) >= 0) {
            result = true;
        }
        return result;
    }

    @Override
    public int[] findDiscountsByStatus(List<Discount> discounts) throws ServiceException {
        int[] paymentByStatus = new int[]{0, 0, 0};
        for (Discount discount : discounts) {
            if (checkActiveDiscount(discount)) {
                paymentByStatus[0]++;
            } else if (checkPlanedDiscount(discount)) {
                paymentByStatus[1]++;
            }
        }
        paymentByStatus[2] = discounts.size() - paymentByStatus[0] - paymentByStatus[1];
        return paymentByStatus;
    }
}
