package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;
import com.epam.jwd_final.service.validator.ValidatorProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedValidatorImplTest {
    private final Validator speedValidator = ValidatorProvider.INSTANCE.getSpeedValidator();

    @Test
    void isValid_Valid() {
        String speed = "100";
        Assertions.assertTrue(speedValidator.isValid(speed));
    }

    @Test
    void isValid_IncorrectInput() {
        String speed = "-120";
        Assertions.assertFalse(speedValidator.isValid(speed));
    }

    @Test
    void isValid_Incorrect_DoubleValue() {
        String speed = "-100.10";
        Assertions.assertFalse(speedValidator.isValid(speed));
    }

    @Test
    void isValid_Incorrect_BigValue() {
        String speed = "10000000";
        Assertions.assertFalse(speedValidator.isValid(speed));
    }

    @Test
    void isValid_Incorrect_NumberAndLetters() {
        String speed = "1qwe0";
        Assertions.assertFalse(speedValidator.isValid(speed));
    }
}