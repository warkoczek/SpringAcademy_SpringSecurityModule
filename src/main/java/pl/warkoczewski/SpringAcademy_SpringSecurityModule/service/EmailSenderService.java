package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import javax.mail.MessagingException;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String text, boolean isHtmlContent) throws MessagingException;
}
