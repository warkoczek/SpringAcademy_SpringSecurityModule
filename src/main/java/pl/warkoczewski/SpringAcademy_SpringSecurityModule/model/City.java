package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum City {

    @JsonProperty("BERLIN")BERLIN("BERLIN"),
    @JsonProperty("POSEN")POSEN("POSEN"),
    @JsonProperty("OSLO")OSLO("OSLO"),
    @JsonProperty("HELSINKI")HELSINKI("HELSINKI");

    private String name;

    City(String name) {
        this.name = name;
    }
}
