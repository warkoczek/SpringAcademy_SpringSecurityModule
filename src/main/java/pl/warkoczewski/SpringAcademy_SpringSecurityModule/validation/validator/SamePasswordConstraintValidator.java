package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password.SamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordConstraintValidator implements ConstraintValidator<SamePassword, RegistrationDataDTO> {

   @Override
   public void initialize(SamePassword constraintAnnotation) {

   }

   @Override
   public boolean isValid(RegistrationDataDTO registrationDataDTO, ConstraintValidatorContext context) {
      if(registrationDataDTO.getPassword() != null && registrationDataDTO.getRePassword() != null){

      }
      return false;
   }
}
