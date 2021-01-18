package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.email;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator.UniqueEmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default " Not unique email!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
