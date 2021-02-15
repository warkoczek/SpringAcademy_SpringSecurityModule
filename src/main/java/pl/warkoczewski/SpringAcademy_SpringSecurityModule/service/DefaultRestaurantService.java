package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.RestaurantRepository;

import java.util.List;
@Service
public class DefaultRestaurantService implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public DefaultRestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
