package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface DiscountDao {
    /**
     * Add new discount in db
     *
     * @param discount - new discount
     */
    void create(Discount discount) throws DaoException;

    /**
     * Find all discounts in db
     *
     * @return list discounts
     */
    List<Discount> findAll() throws DaoException;

    /**
     * Find discount by id
     *
     * @param id - discount id
     * @return discount
     */
    Optional<Discount> findById(Long id) throws DaoException;

    /**
     * Change end date in discount
     *
     * @param discount - discount
     */
    void stopDiscount(Discount discount) throws DaoException;

    /**
     * Update discount in db
     *
     * @param discount - discount with new data
     */
    void updateDiscount(Discount discount) throws DaoException;
}
