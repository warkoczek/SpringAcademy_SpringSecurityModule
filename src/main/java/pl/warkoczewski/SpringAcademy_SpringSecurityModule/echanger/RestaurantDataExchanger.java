package pl.warkoczewski.SpringAcademy_SpringSecurityModule.echanger;

import org.springframework.http.ResponseEntity;

public interface RestaurantDataExchanger {
    ResponseEntity<String[]> exchange();
}
