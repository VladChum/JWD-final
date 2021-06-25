package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TariffPlanDao {
    /**
     * Find all tariffs in db
     *
     * @return list tariffs
     */
    List<TariffPlan> getAllTariff() throws DaoException;

    /**
     * Find tariff in db by id
     *
     * @param tariffId - tariff id
     * @return tariff
     */
    Optional<TariffPlan> findTariffById(int tariffId) throws DaoException;

    /**
     * Find tariff in db by unique name
     *
     * @param name - tariff name
     * @return tariff or return null
     */
    Optional<TariffPlan> findTariffByName(String name) throws DaoException;

    /**
     * Add tariff in db
     *
     * @param tariffPlan - new tariff
     */
    void createTariff(TariffPlan tariffPlan) throws DaoException;

    /**
     * Update tariff data in db
     *
     * @param tariffPlan - tariff with new data
     */
    void updateTariff(TariffPlan tariffPlan) throws DaoException;

    /**
     * Change tariff status for archive him
     *
     * @param tariffId - tariff id where need archive
     */
    void deleteTariff(Long tariffId) throws DaoException;

    /**
     * Change tariff status for activate him
     *
     * @param tariffId - tariff id where need activate
     */
    void activateTariff(Long tariffId) throws DaoException;

    /**
     * Update discount for tariff
     *
     * @param tariffPlan - tariff where need update discount
     * @param discountId - new discount id
     */
    void updateDiscount(TariffPlan tariffPlan, Long discountId) throws DaoException;
}
