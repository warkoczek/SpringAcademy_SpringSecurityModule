package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> listRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
}
