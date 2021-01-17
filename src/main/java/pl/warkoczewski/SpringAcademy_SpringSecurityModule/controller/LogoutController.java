package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/doLogout")
    public String logout(){
        return "/login/sign_in";
    }
}
