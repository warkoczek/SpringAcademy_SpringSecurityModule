package pl.warkoczewski.SpringAcademy_SpringSecurityModule.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.echanger.DefaultRestaurantDataExchanger;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;


@RestController
public class RestaurantApiClientController {
    private final DefaultRestaurantDataExchanger restaurantDataExchanger;

    public RestaurantApiClientController(DefaultRestaurantDataExchanger restaurantDataExchanger) {
        this.restaurantDataExchanger = restaurantDataExchanger;
    }
    /*
    @GetMapping("/rests")
    public List<Restaurant> showAllRestaurants(){
        return restaurantDataExchanger.exchange();
    }*/
}
