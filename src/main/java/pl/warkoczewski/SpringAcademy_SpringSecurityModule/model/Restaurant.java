package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    public Restaurant(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Restaurant() {
    }
}
