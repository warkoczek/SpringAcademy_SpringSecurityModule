package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.VerificationToken;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.EmailSenderService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.RegistrationService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.VerificationTokenService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.groups.BusinessLogic;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final EmailSenderService emailSenderService;
    private final VerificationTokenService verificationTokenService;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder
            , ModelMapper modelMapper, EmailSenderService emailSenderService, VerificationTokenService verificationTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.emailSenderService = emailSenderService;
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    @Validated({BusinessLogic.class})
    public void register(@Valid RegistrationDataDTO registrationDataDTO, HttpServletRequest request) throws MessagingException {
        User user = addUser(registrationDataDTO);
        VerificationToken token = verificationTokenService.addToken(user);
        //String userVerificationLink = userVerificationLink(request, token);
        //String adminVerificationLink = adminVerificationLink(request, token);
        User headAdmin = userRepository.findByRole(Role.ROLE_ADMIN_HEAD);
        if(user.getRole().equals(Role.ROLE_ADMIN)){
            sendEmail(user, userVerificationLink(request, token));
            sendEmail(headAdmin, adminVerificationLink(request, token));
        }else{
            sendEmail(user, userVerificationLink(request, token));
        }

    }

    private void sendEmail(User user, String link) throws MessagingException {
        emailSenderService.sendEmail(user.getEmail(), "Verification Token", link, true );
    }
    private String userVerificationLink(HttpServletRequest request, VerificationToken token) {
        String url = "http://" + request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath() + "/verify/verifyUserToken?token=" + token.getValue();
        return "<html><a href="+url+">Click this link to be able to sign in.</a></html>";
    }
    private String adminVerificationLink(HttpServletRequest request, VerificationToken token) {
        String url = "http://" + request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath() + "/verify/verifyAdminToken?token=" + token.getValue();
        return "<html><a href="+url+">Click this link to give the user admin role</a></html>";
    }

    private User addUser(RegistrationDataDTO registrationDataDTO){
        User user = modelMapper.map(registrationDataDTO, User.class);
        user.setPassword(passwordEncoder.encode(registrationDataDTO.getPassword()));
        return userRepository.save(user);
    }



}
