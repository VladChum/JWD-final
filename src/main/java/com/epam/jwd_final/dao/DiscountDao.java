package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface DiscountDao {
    void create(Discount discount) throws DaoException;

    List<Discount> findAll() throws DaoException;

    Optional<Discount> findById(Long id) throws DaoException;

    void stopDiscount(Discount discount) throws DaoException;

    void activateDiscount(Discount discount) throws DaoException;

    void updateDiscount(Discount discount) throws DaoException;
}
