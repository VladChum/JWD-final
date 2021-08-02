package com.epam.jwd_final.service.validator.impl;

import com.epam.jwd_final.service.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidatorImpl implements Validator {
    private static final String DATE_PATTERN = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";

    DateValidatorImpl() {

    }

    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    @Override
    public boolean isValid(String date) {
        Matcher matcher = pattern.matcher(date);

        if (matcher.matches()) {
            String[] parts = date.split("-");
            int day = Integer.parseInt(parts[2], 10);
            int month = Integer.parseInt(parts[1], 10);
            int year = Integer.parseInt(parts[0], 10);

            if (year < 1000 || year > 3000 || month == 0 || month > 12) {
                return false;
            }
            int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
                monthLength[1] = 29;
            }
            return day > 0 && day <= monthLength[month - 1];
        } else {
            return false;
        }
    }
}
