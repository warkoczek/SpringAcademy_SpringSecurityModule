package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.ValidationService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.email.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Scope("prototype")
@Slf4j
public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {
    private ValidationService validationService;
    @Autowired
    public void setValidationService(ValidationService validationService){
        this.validationService = validationService;
    }
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return validationService.isEmailUnique(email);
    }
}
