package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum City {
    @JsonProperty("BERLIN")BERLIN,
    @JsonProperty("POSEN")POSEN,
    @JsonProperty("OSLO")OSLO,
    @JsonProperty("HELSINKI")HELSINKI;
}
