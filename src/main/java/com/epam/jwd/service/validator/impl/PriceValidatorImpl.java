package com.epam.jwd.service.validator.impl;

import com.epam.jwd.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceValidatorImpl implements Validator {
    private static final String PRICE_PATTERN = "^\\d*\\.?\\d*$";

    private static final Pattern pattern = Pattern.compile(PRICE_PATTERN);

    PriceValidatorImpl() {
    }

    @Override
    public boolean isValid(String price) {
        Matcher matcher = pattern.matcher(price);
        boolean result = false;
        if (matcher.matches() && !price.equals("0") && Float.parseFloat(price) < 100000) {
            result = true;
        }
        return result;
    }
}
