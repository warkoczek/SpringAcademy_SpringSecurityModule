package pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.TokenValidity;


@NoArgsConstructor@AllArgsConstructor
@Data
public class SignInDataDTO {
    private String username;
    private String password;
    private TokenValidity tokenValidity;
}
