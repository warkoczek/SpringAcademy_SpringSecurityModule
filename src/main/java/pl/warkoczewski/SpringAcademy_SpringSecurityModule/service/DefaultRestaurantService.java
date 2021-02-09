package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.City;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.RestaurantRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DefaultRestaurantService implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> listRestaurantsByCity(City city) {
        return restaurantRepository.findAllByCity(city);
    }
}
