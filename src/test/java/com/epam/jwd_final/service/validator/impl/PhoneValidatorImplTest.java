package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneValidatorImplTest {
    private final Validator phoneValidator = ValidatorProvider.INSTANCE.getPhoneValidator();

    @Test
    void isValid_Valid() {
        String validPhone = "+375296029891";
        Assertions.assertTrue(phoneValidator.isValid(validPhone));
    }

    @Test
    void isValid_IncorrectInput() {
        String incorrectPhone = "+375299q9999";
        Assertions.assertFalse(phoneValidator.isValid(incorrectPhone));
    }
}