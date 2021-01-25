package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.SignInDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.TokenValidity;

@Controller
@RequestMapping("/login")
public class SignInController {

    @GetMapping("/sign_in")
    public String displaySignInPage(Model model){
        model.addAttribute("signInDataDTO", new SignInDataDTO());
        model.addAttribute("tokenValidity", TokenValidity.values());
        return "/login/sign_in";
    }

}
