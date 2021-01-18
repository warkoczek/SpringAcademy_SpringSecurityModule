package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator.SamePasswordConstraintValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SamePasswordConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePassword {
}
