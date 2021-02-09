package pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
