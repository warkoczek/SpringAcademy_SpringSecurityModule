package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.DisplayRestaurantDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Restaurant;

@Configuration
public class BeanConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
