package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface RegistrationService {
    void register(RegistrationDataDTO registrationDataDTO, HttpServletRequest request) throws MessagingException;
    void verifyToken(String token);
}
