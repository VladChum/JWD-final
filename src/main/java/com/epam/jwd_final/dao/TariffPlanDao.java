package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface TariffPlanDao {
    List<TariffPlan> getAllTariff() throws DaoException;

    Optional<TariffPlan> findTariffById(int tariffId) throws DaoException;

    /**
     * todo
     * <p>
     * add cheng price and speed
     * add cheng discount
     */
    void createTariff(TariffPlan tariffPlan) throws DaoException;

    void updateTariff(TariffPlan tariffPlan);

    void deleteTariff(Long tariffId) throws DaoException;

    void activateTariff(Long tariffId) throws DaoException;

    void updateDiscount(TariffPlan tariffPlan, Long discountId) throws DaoException;
}
