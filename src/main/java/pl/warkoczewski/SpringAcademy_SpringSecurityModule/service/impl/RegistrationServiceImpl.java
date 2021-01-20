package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.exception.UserVerificationException;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.VerificationToken;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.VerificationTokenRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.EmailSenderService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.RegistrationService;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.validation.groups.BusinessLogic;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final VerificationTokenRepository verificationTokenRepository;
    private final EmailSenderService emailSenderService;

    public RegistrationServiceImpl(UserRepository userRepository
            , PasswordEncoder passwordEncoder
            , ModelMapper modelMapper, VerificationTokenRepository verificationTokenRepository, EmailSenderService emailSenderService) throws MessagingException {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.verificationTokenRepository = verificationTokenRepository;
        this.emailSenderService = emailSenderService;
       /* RegistrationDataDTO registrationDataDTO =
                new RegistrationDataDTO(Role.ROLE_USER, "uwarkocz", "awarkoczewskiaj@yahoo.com", "123", "123"
                        );
        register(registrationDataDTO);
        RegistrationDataDTO registrationDataDTO1 =
                new RegistrationDataDTO(Role.ROLE_ADMIN, "awarkocz", "awarkoczewsk@yahoo.com", "456", "456"
                );
        register(registrationDataDTO1);
        RegistrationDataDTO registrationDataDTO2 =
                new RegistrationDataDTO(Role.ROLE_ADMIN_HEAD, "ahwarkocz", "awarkoczews@yahoo.com", "789", "789"
                );
        register(registrationDataDTO2);*/
    }

    @Override
    @Validated({BusinessLogic.class})
    public void register(@Valid RegistrationDataDTO registrationDataDTO, HttpServletRequest request) throws MessagingException {
        User user = addUser(registrationDataDTO);
        VerificationToken token = addToken(user);
        String link = getLink(request, token);
        emailSenderService.sendEmail(user.getEmail(), "Verification Token", link, true );

    }

    private String getLink(HttpServletRequest request, VerificationToken token) {
        String url = "http://" + request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath() + "/register/verifyToken?token=" + token.getValue();
        return "<html><a href="+url+">Click this link to be able to sign in.</a></html>";
    }

    private User addUser(RegistrationDataDTO registrationDataDTO){
        User user = modelMapper.map(registrationDataDTO, User.class);
        user.setPassword(passwordEncoder.encode(registrationDataDTO.getPassword()));
        return userRepository.save(user);
    }
    private VerificationToken addToken(User user){
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setValue(UUID.randomUUID().toString());
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public void verifyToken(String token) {
        Optional<VerificationToken> optionalVerificationToken = verificationTokenRepository.findByValue(token);
        if(optionalVerificationToken.isPresent()){
            User user = optionalVerificationToken.get().getUser();
            log.info("User is not enabled yet {}", user);
            user.setEnabled(true);
            userRepository.save(user);
            log.info("User is enabled {}", user);
        }else {
            throw new UserVerificationException("No such user token");
        }

    }
}
