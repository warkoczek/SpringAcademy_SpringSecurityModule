package pl.warkoczewski.SpringAcademy_SpringSecurityModule.echanger;

import org.springframework.http.ResponseEntity;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

import java.util.List;

public interface RestaurantDataExchanger {
   ResponseEntity<String[]> exchange();
}
