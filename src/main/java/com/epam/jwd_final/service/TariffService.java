package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.ServiceException;

import java.util.List;

public interface TariffService {
    List<TariffPlan> getAllTariff() throws ServiceException;
}
