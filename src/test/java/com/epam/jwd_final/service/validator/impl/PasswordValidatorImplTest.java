package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;
import com.epam.jwd_final.service.validator.ValidatorProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorImplTest {
    private final Validator passwordValidator = ValidatorProvider.INSTANCE.getPasswordValidator();

    @Test
    void isValid_Valid() {
        String password = "Password1";
        Assertions.assertTrue(passwordValidator.isValid(password));
    }

    @Test
    void isValid_IncorrectInput() {
        String password = "qweqw";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @Test
    void isValid_Incorrect_short() {
        String password = "qw";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @Test
    void isValid_Incorrect_withoutNumber() {
        String password = "Password";
        Assertions.assertFalse(passwordValidator.isValid(password));
    }

    @Test
    void isValid_Incorrect_withOutUpperCase() {
        String passwoed = "pssword1";
        Assertions.assertFalse(passwordValidator.isValid(passwoed));
    }
}