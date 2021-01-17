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
                new RegistrationDataDTO(Role.ROLE_USER, "uwarkocz", "awarkoczewski@yahoo.com", "123", "123"
                        );
        register(registrationDataDTO);
        RegistrationDataDTO registrationDataDTO1 =
                new RegistrationDataDTO(Role.ROLE_ADMIN, "awarkocz", "awarkoczewsk@yahoo.com", "456", "456"
                );
        register(registrationDataDTO1);
        RegistrationDataDTO registrationDataDTO2 =
                new RegistrationDataDTO(Role.ROLE_ADMIN_HEAD, "ahwarkocz", "awarkoczews@yahoo.com", "789", "789"
                );
        register(registrationDataDTO2);
    }

    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {
        User user = modelMapper.map(registrationDataDTO, User.class);
        user.setPassword(passwordEncoder.encode(registrationDataDTO.getPassword()));
        userRepository.save(user);
    }
}
