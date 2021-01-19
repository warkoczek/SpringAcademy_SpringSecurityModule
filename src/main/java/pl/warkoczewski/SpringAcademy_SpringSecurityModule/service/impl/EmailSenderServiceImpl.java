package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendEmail(String to, String subject, String text, String isHtmlContent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        mimeMessageHelper.setText(isHtmlContent);
        javaMailSender.send(mimeMessage);
    }
}
