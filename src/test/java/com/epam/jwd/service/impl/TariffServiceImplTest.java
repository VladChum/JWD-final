package com.epam.jwd.service.impl;

import com.epam.jwd.entity.TariffPlan;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.TariffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TariffServiceImplTest {
    private List<TariffPlan> tariffPlans;
    private TariffService tariffService;

    @BeforeEach
    void setup() {
        tariffPlans = new ArrayList<>();
        tariffPlans.add(new TariffPlan(1L, "first", BigDecimal.ONE, null, 100, true));
        tariffPlans.add(new TariffPlan(2L, "first", BigDecimal.ONE, null, 100, true));
        tariffPlans.add(new TariffPlan(3L, "first", BigDecimal.ONE, null, 100, false));
        tariffPlans.add(new TariffPlan(4L, "first", BigDecimal.ONE, null, 100, false));
        tariffPlans.add(new TariffPlan(5L, "first", BigDecimal.ONE, null, 100, false));
    }

    @Test
    void findAllTariff() throws ServiceException {
        tariffService = mock(TariffServiceImpl.class);
        when(tariffService.findAllTariff()).thenReturn(tariffPlans);
        List<TariffPlan> tariffPlans1 = tariffService.findAllTariff();
        assertEquals(tariffPlans, tariffPlans1);
    }

    @Test
    void findById() throws ServiceException {
        tariffService = mock(TariffServiceImpl.class);
        when(tariffService.findById(1)).thenReturn(new TariffPlan(1L, "first", BigDecimal.ONE, null, 100, true));
        assertEquals(tariffPlans.get(0), tariffService.findById(1));
    }


    @Test
    void findTariffsByStatus_valid() {
        tariffService = ServiceProvider.INSTANCE.getTariffService();
        int[] validArray = new int[]{2, 3};
        Assertions.assertArrayEquals(validArray, tariffService.findTariffsByStatus(tariffPlans));
    }

    @Test
    void findTariffsByStatus_false() {
        tariffService = ServiceProvider.INSTANCE.getTariffService();
        int[] incorrectArray = new int[]{3, 3};
        Assertions.assertFalse(Arrays.equals(incorrectArray, tariffService.findTariffsByStatus(tariffPlans)));
    }
}