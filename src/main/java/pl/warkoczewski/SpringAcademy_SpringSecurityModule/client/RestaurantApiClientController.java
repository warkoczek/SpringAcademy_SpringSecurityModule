package pl.warkoczewski.SpringAcademy_SpringSecurityModule.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.echanger.DefaultRestaurantDataExchanger;



public class RestaurantApiClientController {
    private final DefaultRestaurantDataExchanger restaurantDataExchanger;

    public RestaurantApiClientController(DefaultRestaurantDataExchanger restaurantDataExchanger) {
        this.restaurantDataExchanger = restaurantDataExchanger;
    }


    public String[] showAllRestaurants(){
        return restaurantDataExchanger.exchange().getBody();
    }
}
