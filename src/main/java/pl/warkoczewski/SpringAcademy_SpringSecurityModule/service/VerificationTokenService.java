package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken addToken(User user);
    void verifyUserToken(String token);
    void verifyAdminToken(String token);
}
