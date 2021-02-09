package pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.City;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByCity(City city);
}
