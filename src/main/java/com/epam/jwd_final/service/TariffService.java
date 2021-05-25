package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;

public interface TariffService {
    List<TariffPlan> findAllTariff() throws ServiceException;

    void updateTariff(Long userId, Long newTariffId) throws ServiceException;

    TariffPlan findById(int tariffId) throws ServiceException;

    void createTariff(TariffPlan tariffPlan) throws ServiceException;

    void deleteTariff(Long tariffId) throws ServiceException;
}
