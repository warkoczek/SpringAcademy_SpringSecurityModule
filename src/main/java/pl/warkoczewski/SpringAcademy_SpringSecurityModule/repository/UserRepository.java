package pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
