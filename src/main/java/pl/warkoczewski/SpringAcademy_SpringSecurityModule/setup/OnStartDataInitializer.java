package pl.warkoczewski.SpringAcademy_SpringSecurityModule.setup;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.City;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OnStartDataInitializer implements ApplicationRunner {
    private final RestaurantRepository restaurantRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveRestaurants();
    }

    private List<Restaurant> saveRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Mc Pizza", City.BERLIN));
        restaurants.add(new Restaurant("Donald Hut", City.BERLIN));
        restaurants.add(new Restaurant("Mc Pizza", City.HELSINKI));
        restaurants.add(new Restaurant("Donald Hut", City.HELSINKI));
        restaurants.add(new Restaurant("Donald Hut", City.POSEN));
        restaurants.add(new Restaurant("Donald Hut", City.OSLO));
        return restaurantRepository.saveAll(restaurants);
    }
}
