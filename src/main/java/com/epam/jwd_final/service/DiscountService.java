package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;

public interface DiscountService {
    List<Discount> findAll() throws ServiceException;
    void create(Discount discount) throws ServiceException;
}
