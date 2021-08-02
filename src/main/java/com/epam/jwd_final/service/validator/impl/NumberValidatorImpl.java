package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidatorImpl implements Validator {
    private static final String NUMBER_PATTERN = "^\\d*\\.?\\d*$";

    private static final Pattern pattern = Pattern.compile(NUMBER_PATTERN);

    NumberValidatorImpl() {
        
    }

    @Override
    public boolean isValid(String speed) {
        Matcher matcher = pattern.matcher(speed);
        boolean result = false;
        if (matcher.matches() && Double.parseDouble(speed) > 0) {
            result = true;
        }
        return result;
    }
}
