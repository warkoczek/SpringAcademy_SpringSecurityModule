package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import jdk.net.SocketFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.City;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.RestaurantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants/{city}")
    public ResponseEntity<List<Restaurant>> displayAllRestaurantsByCity(@PathVariable("city") String city){
        List<Restaurant> restaurants = restaurantService.listRestaurantsByCity(city);
        if(restaurants.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant){
        if(restaurant != null){
            return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
