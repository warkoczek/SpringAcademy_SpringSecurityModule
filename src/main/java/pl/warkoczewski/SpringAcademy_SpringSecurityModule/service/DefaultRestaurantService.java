package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;
@Service
public class DefaultRestaurantService implements RestaurantService {

    @Override
    public List<Restaurant> listRestaurants() {
        return null;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return null;
    }
}
