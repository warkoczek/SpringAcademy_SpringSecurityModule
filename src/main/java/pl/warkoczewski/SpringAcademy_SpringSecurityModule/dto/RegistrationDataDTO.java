package pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;

@NoArgsConstructor@AllArgsConstructor
@Data
public class RegistrationDataDTO {
    private Role role;
    private String username;
    private String email;
    private String password;
    private String rePassword;

}
