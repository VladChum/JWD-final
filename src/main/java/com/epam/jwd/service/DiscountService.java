package com.epam.jwd.service;

import com.epam.jwd.entity.Discount;
import com.epam.jwd.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    /**
     * Find discount in db by id
     *
     * @param id - discount id
     * @return discount
     */
    Optional<Discount> findById(Long id) throws ServiceException;

    /**
     * Find all discount in db
     *
     * @return list of discounts
     */
    List<Discount> findAll() throws ServiceException;

    /**
     * Add new discount id db
     *
     * @param discount - new discount
     */
    void create(Discount discount) throws ServiceException;

    /**
     * Suspends the active discount by changing the end date
     *
     * @param id - discount id
     */
    void stopDiscountById(Long id) throws ServiceException;

    /**
     * Update data about discount
     *
     * @param discount - discount with new parameters
     */
    void update(Discount discount) throws ServiceException;

    /**
     * Check if active discount now
     *
     * @param discount - find discount
     * @return result of checking
     */
    boolean checkActiveDiscount(Discount discount) throws ServiceException;

    /**
     * Check if planed discount
     *
     * @param discount - find discount
     * @return result of checking
     */
    boolean checkPlanedDiscount(Discount discount) throws ServiceException;

    /**
     * Sort discount by status in new array
     *
     * @param discounts - list discounts
     * @return array of 3 elements 0 - active, 1 - planed, 2- archive
     */
    int[] findDiscountsByStatus(List<Discount> discounts) throws ServiceException;
}
