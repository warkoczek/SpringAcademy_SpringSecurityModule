package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.username;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator.UniqueUsernameConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = UniqueUsernameConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Not unique username!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
