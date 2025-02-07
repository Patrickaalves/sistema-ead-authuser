package com.ead.authuser.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordConstraintImpl implements ConstraintValidator<PasswordConstraint, String> { // Terei que validar nesse caso o tipo String

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$";

    @Override
    public void initialize(PasswordConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // password : Valor dentro do campo que recebo, se for enviado o valor na senha 77TEste,
        // o campo password ira ter essa informação

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        if (password == null || password.trim().isEmpty() || password.contains(" ")) {
            return false;
        } else if (!pattern.matcher(password).matches()){
            return false;
        }

        return true;
    }


}
