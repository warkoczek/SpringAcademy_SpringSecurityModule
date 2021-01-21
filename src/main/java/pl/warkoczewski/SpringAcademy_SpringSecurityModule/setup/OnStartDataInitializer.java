package pl.warkoczewski.SpringAcademy_SpringSecurityModule.setup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.VerificationToken;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.VerificationTokenRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class OnStartDataInitializer implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = createUsers();
        log.info("After users creation {}", users);
        List<VerificationToken> tokens = createTokens(users);
        log.info("After tokens creation {}", tokens);

    }

    private List<User> createUsers() {
        List<User> users = Arrays.asList(
                new User("wojtek", "wojtek@yahoo.com", passwordEncoder.encode("Wojteczek8("), Role.ROLE_ADMIN_HEAD, true)
                , new User("warkocz", "awarkoczewski@yahoo.com", passwordEncoder.encode("Joleczka8("), Role.ROLE_ADMIN, true)
                , new User("markocz", "andresik82@gmail.com", passwordEncoder.encode("Joleczka8&"), Role.ROLE_USER, true));
        return userRepository.saveAll(users);
    }
    private List<VerificationToken> createTokens(List<User> users){
        return verificationTokenRepository.saveAll(
                users.stream().map(user -> new VerificationToken(UUID.randomUUID().toString(), user)).collect(Collectors.toList()));
    }


}
