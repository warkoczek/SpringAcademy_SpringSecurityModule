package pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.constraint.UniqueUsername;

import javax.validation.constraints.NotNull;

@NoArgsConstructor@AllArgsConstructor
@Data
public class RegistrationDataDTO {
    private Role role;
    @NotNull
    @UniqueUsername(message = " Chosen username is already in use. Try different one, please!")
    private String username;
    private String email;
    private String password;
    private String rePassword;

}
