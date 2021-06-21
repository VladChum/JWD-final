package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorImpl implements Validator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,30}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean isValid(String validateData) {
        Matcher matcher = pattern.matcher(validateData);
        return matcher.matches();
    }
}
