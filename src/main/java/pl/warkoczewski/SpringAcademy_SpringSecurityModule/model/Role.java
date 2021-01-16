package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("ROLE_USER")ROLE_USER,
    @JsonProperty("ROLE_ADMIN")ROLE_ADMIN,
    @JsonProperty("ROLE_ADMIN_HEAD")ROLE_ADMIN_HEAD;

}
