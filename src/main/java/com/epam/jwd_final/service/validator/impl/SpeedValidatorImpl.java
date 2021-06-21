package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeedValidatorImpl implements Validator {
    private static final String SPEED_PATTERN = "^[0-9]+$";

    private static final Pattern pattern = Pattern.compile(SPEED_PATTERN);

    @Override
    public boolean isValid(String speed) {
        Matcher matcher = pattern.matcher(speed);
        boolean result = false;
        if (matcher.matches() && ! speed.equals("0") && Integer.parseInt(speed) < 100000) {
            result = true;
        }
        return result;
    }
}
