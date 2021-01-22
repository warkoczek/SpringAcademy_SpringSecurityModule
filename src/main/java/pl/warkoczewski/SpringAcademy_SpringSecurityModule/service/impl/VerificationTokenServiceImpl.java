package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.exception.VerificationTokenException;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.VerificationToken;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.VerificationTokenRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.VerificationTokenService;

import java.util.UUID;
@Service
@Slf4j
public class VerificationTokenServiceImpl implements VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserRepository userRepository;

    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository, UserRepository userRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VerificationToken addToken(User user){
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setValue(UUID.randomUUID().toString());
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public void verifyUserToken(String token) {
        User user = getUser(token);
        if(!isAuthorizedAndEnabledAsAdmin(user)){
            user.setEnabled(true);
            user.setRole(Role.ROLE_USER);
            userRepository.save(user);
        }

    }

    @Override
    public void verifyAdminToken(String token) {
        User user = getUser(token);
        if(!isAuthorizedAndEnabledAsAdmin(user)){
            user.setEnabled(true);
            user.setRole(Role.ROLE_ADMIN);
            userRepository.save(user);
        }

    }
    private User getUser(String token) {
        return verificationTokenRepository.findByValue(token)
                .orElseThrow(()-> new VerificationTokenException("Verification Token with this value does not exist"))
                .getUser();
    }
    private boolean isAuthorizedAndEnabledAsAdmin(User user){
        return user.getRole().equals(Role.ROLE_ADMIN) && user.isEnabled();
    }
}
