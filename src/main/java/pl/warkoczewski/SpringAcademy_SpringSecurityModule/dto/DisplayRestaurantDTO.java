package pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisplayRestaurantDTO {
    private String name;
    private String city;
}
