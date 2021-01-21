package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/home")
    public String displayHomePage(){
        return "/home/home";
    }

}
