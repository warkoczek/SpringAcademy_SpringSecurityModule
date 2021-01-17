package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @GetMapping("/sign_up")
    public String displayRegistrationPage(Model model){
        model.addAttribute("registrationDataDTO", new RegistrationDataDTO());
        return "/register/sign_up";
    }
}
