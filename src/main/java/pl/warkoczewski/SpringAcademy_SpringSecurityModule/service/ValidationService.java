package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

public interface ValidationService {
    boolean isUsernameUnique(String username);

    boolean isEmailUnique(String email);
}
