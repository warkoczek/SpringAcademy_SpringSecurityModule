package pl.warkoczewski.SpringAcademy_SpringSecurityModule.exception;

public class VerificationTokenException extends RuntimeException {
    public VerificationTokenException(String message) {
        super(message);
    }
}
