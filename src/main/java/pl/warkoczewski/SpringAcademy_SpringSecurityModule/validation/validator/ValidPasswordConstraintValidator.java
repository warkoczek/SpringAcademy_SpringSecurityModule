package pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.validator;

import org.passay.*;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ValidPasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
   public void initialize(ValidPassword constraint) {
   }

   public boolean isValid(String password, ConstraintValidatorContext context) {
      PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(
              new LengthRule(8, 20),
              new CharacterRule(EnglishCharacterData.UpperCase, 1),
              new CharacterRule(EnglishCharacterData.Digit, 1),
              new CharacterRule(EnglishCharacterData.Special, 1),
              new WhitespaceRule(),
              new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 4, false),
              new IllegalSequenceRule(EnglishSequenceData.Numerical, 4, false)

      ));
      RuleResult ruleResult  = passwordValidator.validate(new PasswordData(password));
      if(ruleResult.isValid()){
         return true;
      }
      List<String> messages = passwordValidator.getMessages(ruleResult);
      String messageTemplate = String.join(",", messages);
      context.buildConstraintViolationWithTemplate(messageTemplate)
              .addConstraintViolation()
              .disableDefaultConstraintViolation();
      return false;
   }
}
