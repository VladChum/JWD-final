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
}
