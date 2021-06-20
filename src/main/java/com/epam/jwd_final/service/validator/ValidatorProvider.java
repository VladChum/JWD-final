package com.epam.jwd_final.service.validator;

import com.epam.jwd_final.service.validator.impl.*;

public enum ValidatorProvider {
    INSTANCE;

    private final Validator emailValidator = new EmailValidatorImpl();
    private final Validator passwordValidator = new PasswordValidatorImpl();
    private final Validator phoneValidator = new PhoneValidatorImpl();
    private final Validator priceValidator = new PriceValidatorImpl();
    private final Validator speedValidator = new SpeedValidatorImpl();

    public Validator getEmailValidator() {
        return emailValidator;
    }

    public Validator getPasswordValidator() {
        return passwordValidator;
    }

    public Validator getPhoneValidator() {
        return phoneValidator;
    }

    public Validator getPriceValidator() {
        return priceValidator;
    }

    public Validator getSpeedValidator() {
        return speedValidator;
    }
}
