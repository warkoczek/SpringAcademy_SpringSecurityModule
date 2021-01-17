package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        RegistrationDataDTO registrationDataDTO =
                new RegistrationDataDTO(Role.ROLE_USER, "warkocz", "awarkoczewski@yahoo.com", "123", "123"
                        );
        register(registrationDataDTO);
    }

    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {
        User user = modelMapper.map(registrationDataDTO, User.class);
        user.setPassword(passwordEncoder.encode(registrationDataDTO.getPassword()));
        userRepository.save(user);
    }
}
