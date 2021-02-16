package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

public interface JwtService {
    String getJsonWebToken(boolean isAdmin);
}
