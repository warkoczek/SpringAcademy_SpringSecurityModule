package pl.warkoczewski.SpringAcademy_SpringSecurityModule.exception;

public class UserVerificationTokenException extends RuntimeException {
    public UserVerificationTokenException(String message) {
        super(message);
    }
}
