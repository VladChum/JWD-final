package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.DiscountDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.DiscountService;

import java.util.List;

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
}
