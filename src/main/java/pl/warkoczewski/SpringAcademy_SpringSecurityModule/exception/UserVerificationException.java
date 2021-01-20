package pl.warkoczewski.SpringAcademy_SpringSecurityModule.exception;

public class UserVerificationException  extends RuntimeException {
    public UserVerificationException(String message) {
        super(message);
    }
}
