package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.TariffPlanDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.TariffService;

import java.util.List;

public class TariffServiceImpl implements TariffService {
    private final TariffPlanDao tariffPlanDao = DaoProvider.INSTANCE.getTariffPlanDao();

    @Override
    public List<TariffPlan> findAllTariff() throws ServiceException {
        try {
            return tariffPlanDao.getAllTariff();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public TariffPlan findById(int tariffId) throws ServiceException {
        TariffPlan tariffPlan = null;
        try {
            tariffPlan = tariffPlanDao.findTariffById(tariffId).get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return tariffPlan;
    }

    @Override
    public void updateTariff(Long userId, Long newTariffId) throws ServiceException {

    }

    @Override
    public void activateTariff(Long tariffId) throws ServiceException {
        try {
            tariffPlanDao.activateTariff(tariffId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createTariff(TariffPlan tariffPlan) throws ServiceException {
        try {
            tariffPlanDao.createTariff(tariffPlan);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTariff(Long tariffId) throws ServiceException {
        try {
            tariffPlanDao.deleteTariff(tariffId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateTariffDiscount(TariffPlan tariffPlan, Long discountId) throws ServiceException {
        try {
            tariffPlanDao.updateDiscount(tariffPlan, discountId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
