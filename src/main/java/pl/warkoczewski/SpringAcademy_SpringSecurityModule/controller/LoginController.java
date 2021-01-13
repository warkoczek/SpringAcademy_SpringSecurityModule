package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/forAll")
    public String forAll(){
        return "forAll";
    }
    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "forAdmin";
    }
    @GetMapping("/forUser")
    public String forUser(){
        return "forUser";
    }
}
