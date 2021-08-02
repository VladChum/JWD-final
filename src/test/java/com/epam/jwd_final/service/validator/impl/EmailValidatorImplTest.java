package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailValidatorImplTest {
    private final Validator emailValidator = ValidatorProvider.INSTANCE.getEmailValidator();

    @Test
    void isValid() {
        String validEmail = "DegaDega001@mail.ru";
        Assertions.assertTrue(emailValidator.isValid(validEmail));
    }

    @Test
    void isValid_Incorrect() {
        String invalidEmail = "@gmail.com";
        Assertions.assertFalse(emailValidator.isValid(invalidEmail));
    }

    @Test
    void isValid_Valid_WithTwoPoints() {
        String incorrectEmail = "abcd.er@bsuir.gmail.ru";
        Assertions.assertTrue(emailValidator.isValid(incorrectEmail));
    }

}