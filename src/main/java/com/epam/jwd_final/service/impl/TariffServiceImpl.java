package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.TariffPlanDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.entity.User;
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
    public void updateTariff(TariffPlan tariffPlan) throws ServiceException {
        try {
            tariffPlanDao.updateTariff(tariffPlan);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
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

    @Override
    public boolean checkExistence(Long tariffId, String name) throws ServiceException {
        boolean result = false;
        try {
            if ((tariffPlanDao.findTariffById(tariffId.intValue()).isPresent() &&
                    tariffPlanDao.findTariffById(tariffId.intValue()).get().getName().equals(name))
                    || tariffPlanDao.findTariffByName(name).isPresent()) {
                result = true;
            }
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean checkExistenceForUpdate(Long tariffId, String name) throws ServiceException {
        boolean result = false;
        try {
            if (tariffPlanDao.findTariffById(tariffId.intValue()).isPresent() &&
                    !tariffPlanDao.findTariffById(tariffId.intValue()).get().getName().equals(name)
                    && tariffPlanDao.findTariffByName(name).isPresent()) {
                result = true;
            }
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }
        return result;
    }

    @Override
    public int[] findTariffsByStatus(List<TariffPlan> tariffPlans) {
        int[] tariffsByStatus = new int[]{0, 0};
        for (TariffPlan tariffPlan : tariffPlans) {
            if (tariffPlan.isActive()) {
                tariffsByStatus[0]++;
            } else {
                tariffsByStatus[1]++;
            }
        }
        return tariffsByStatus;
    }
}
