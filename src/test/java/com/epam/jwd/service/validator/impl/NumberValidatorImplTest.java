package com.epam.jwd.service.validator.impl;

import com.epam.jwd.service.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberValidatorImplTest {
    private final Validator numberValidator = ValidatorProvider.INSTANCE.getNumberValidator();

    @Test
    void isValid_Valid() {
        String validNumber = "100";
        Assertions.assertTrue(numberValidator.isValid(validNumber));
    }

    @Test
    void isValid_decimal_Valid() {
        String validNumber = "100.5";
        Assertions.assertTrue(numberValidator.isValid(validNumber));
    }

    @Test
    void isValid_decimal_NotValid() {
        String incorrectNumber = "100,5";
        Assertions.assertFalse(numberValidator.isValid(incorrectNumber));
    }
}