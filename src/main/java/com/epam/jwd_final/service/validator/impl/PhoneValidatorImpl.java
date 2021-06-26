package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidatorImpl implements Validator {
    private static final String PHONE_PATTERN = "^\\+?([0-9]{3})\\)?[-. ]?([0-9]{5})[-. ]?([0-9]{4})$";

    private static final Pattern pattern = Pattern.compile(PHONE_PATTERN);

    @Override
    public boolean isValid(String phone) {
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
