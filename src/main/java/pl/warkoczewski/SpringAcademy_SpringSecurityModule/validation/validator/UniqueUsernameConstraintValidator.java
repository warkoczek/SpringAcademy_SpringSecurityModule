package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.ValidationService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.username.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Scope("prototype")
@Slf4j
public class UniqueUsernameConstraintValidator implements ConstraintValidator<UniqueUsername, String> {
    private final ValidationService validationService;

    public UniqueUsernameConstraintValidator(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return validationService.isUsernameUnique(username);
    }
}
