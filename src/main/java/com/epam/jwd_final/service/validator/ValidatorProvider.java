package com.epam.jwd_final.service.validator;

import com.epam.jwd_final.service.validator.impl.EmailValidatorImpl;
import com.epam.jwd_final.service.validator.impl.PasswordValidatorImpl;
import com.epam.jwd_final.service.validator.impl.PhoneValidatorImpl;

public enum ValidatorProvider {
    INSTANCE;

    private final Validator emailValidator = new EmailValidatorImpl();
    private final Validator passwordValidator = new PasswordValidatorImpl();
    private final Validator phoneValidator = new PhoneValidatorImpl();

    public Validator getEmailValidator() {
        return emailValidator;
    }

    public Validator getPasswordValidator() {
        return passwordValidator;
    }

    public Validator getPhoneValidator() {
        return phoneValidator;
    }
}
