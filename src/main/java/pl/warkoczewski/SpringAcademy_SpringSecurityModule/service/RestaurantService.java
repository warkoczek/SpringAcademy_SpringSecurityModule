package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.City;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    List<Restaurant> listRestaurantsByCity(City city);
}
