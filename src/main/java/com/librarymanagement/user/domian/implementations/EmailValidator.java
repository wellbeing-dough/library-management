package com.librarymanagement.user.domian.implementations;

import com.librarymanagement.user.domian.component.NormalEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<NormalEmail, String> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w+\\-]+(\\.[\\w+\\-]+)*@[\\w\\-]+(\\.[\\w\\-]+)*(\\.[a-zA-Z]{2,})$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && EMAIL_PATTERN.matcher(value).matches();
    }
}