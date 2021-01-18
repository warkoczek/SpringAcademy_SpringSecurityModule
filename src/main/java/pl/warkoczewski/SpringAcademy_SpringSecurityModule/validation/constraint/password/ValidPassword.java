package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator.ValidPasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Documented
@Constraint(validatedBy = ValidPasswordConstraintValidator.class)
@Target({FIELD, METHOD, TYPE})
@Retention(RUNTIME)
public @interface ValidPassword {
    String message() default " Not valid password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
