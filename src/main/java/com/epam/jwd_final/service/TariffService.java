package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;

public interface TariffService {
    /**
     * Find all tariffs in db
     *
     * @return list tariffs
     */
    List<TariffPlan> findAllTariff() throws ServiceException;

    /**
     * Update tariff data in db
     *
     * @param tariffPlan - tariff with new data
     */
    void updateTariff(TariffPlan tariffPlan) throws ServiceException;

    /**
     * Find tariff in db by id
     *
     * @param tariffId - tariff id
     * @return tariff or return null
     */
    TariffPlan findById(int tariffId) throws ServiceException;

    /**
     * Add new tariff in db
     *
     * @param tariffPlan - nwe tariff
     */
    void createTariff(TariffPlan tariffPlan) throws ServiceException;

    /**
     * Archive active tariff
     *
     * @param tariffId - tariff id
     */
    void deleteTariff(Long tariffId) throws ServiceException;

    /**
     * Activate tariff from archive
     *
     * @param tariffId - tariff id
     */
    void activateTariff(Long tariffId) throws ServiceException;

    /**
     * Update or add new discount for tariff
     *
     * @param tariffPlan - tariff plan where need to update discount
     * @param discountId - new discount id
     */
    void updateTariffDiscount(TariffPlan tariffPlan, Long discountId) throws ServiceException;

    /**
     * Check if exist tariff with this name
     *
     * @param tariffId - tariff id
     * @param name     - tariff name
     * @return result of check
     */
    boolean checkExistence(Long tariffId, String name) throws ServiceException;

    /**
     * Sort tariffs by status in new array
     *
     * @param tariffPlans - list tariffs
     * @return array of 3 elements 0 - active, 1 - archive
     */
    int[] findTariffsByStatus(List<TariffPlan> tariffPlans);

}
