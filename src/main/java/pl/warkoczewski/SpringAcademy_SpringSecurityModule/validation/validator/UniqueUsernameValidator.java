package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
