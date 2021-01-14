package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @GetMapping("/admin")
    public String getAdminPage(Principal principal){
        return "forAdmin " + principal.getName();
    }
    @GetMapping("/user")
    public String getUserPage(Principal principal){
        return "forUser " + principal.getName();
    }
    @GetMapping("/alien")
    public String getAlienPage(){
        return "Hi Alien";
    }
    @GetMapping("/bye")
    public String getByePage(){
        return "bye bye!";
    }
}
