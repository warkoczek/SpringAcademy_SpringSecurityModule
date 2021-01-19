package pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.email.UniqueEmail;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password.SamePassword;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.password.ValidPassword;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.username.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor@AllArgsConstructor
@Data@SamePassword
public class RegistrationDataDTO {
    private Role role;
    @NotNull
    @UniqueUsername(message = " Chosen username is already in use. Try different one, please!")
    @Size(min = 4, max = 12, message= " Username length out of bound! Try different one, please!")
    private String username;
    @Email@UniqueEmail(message = " Chosen email has been used by one of our registered users. Try different one, please!")
    private String email;
    @NotNull
    @ValidPassword(message = " Chosen password is not valid! Try different one, please!")
    private String password;
    @NotNull
    @ValidPassword(message = " Chosen password is not valid! Try different one, please!")
    private String rePassword;

}
