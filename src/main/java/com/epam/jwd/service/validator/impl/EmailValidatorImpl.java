package com.epam.jwd.service.validator.impl;

import com.epam.jwd.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorImpl implements Validator {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    EmailValidatorImpl() {

    }

    @Override
    public boolean isValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
