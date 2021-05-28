package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    Optional<Discount> findById(Long id) throws ServiceException;

    List<Discount> findAll() throws ServiceException;

    void create(Discount discount) throws ServiceException;

    void stopDiscountById(Long id) throws ServiceException;

    void update(Discount discount) throws ServiceException;

}
