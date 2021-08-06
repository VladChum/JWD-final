package com.epam.jwd.service.validator.impl;

import com.epam.jwd.service.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateValidatorImplTest {
    private final Validator dateValidator = ValidatorProvider.INSTANCE.getDateValidator();

    @Test
    public void isValid_Valid() {
        String validDate = "2021-03-03";
        Assertions.assertTrue(dateValidator.isValid(validDate));
    }

    @Test
    public void isValid_Not_Valid() {
        String validDate = "2021-03-33";
        Assertions.assertFalse(dateValidator.isValid(validDate));
    }

    @Test
    public void isValid_February_Valid() {
        String validDate = "2020-02-29";
        Assertions.assertTrue(dateValidator.isValid(validDate));
    }

    @Test
    public void isValid_February_NotValid() {
        String validDate = "2021-02-29";
        Assertions.assertFalse(dateValidator.isValid(validDate));
    }

    @Test
    public void isValid_IncorrectDate() {
        String validDate = "2021-1-29";
        Assertions.assertFalse(dateValidator.isValid(validDate));
    }
}