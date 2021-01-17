package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl.RegistrationServiceImpl;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationServiceImpl registrationService;

    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/sign_up")
    public String displayRegistrationPage(Model model){
        model.addAttribute("registrationDataDTO", new RegistrationDataDTO());
        model.addAttribute("roles", Role.values());
        return "/register/sign_up";
    }
    @PostMapping("/sign_up")
    public String processRegistrationForm(@ModelAttribute("registrationDataDTO") RegistrationDataDTO registrationDataDTO){
        registrationService.register(registrationDataDTO);
        return "redirect:/home/home";
    }
}
