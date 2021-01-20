package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.dto.RegistrationDataDTO;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.Role;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.impl.RegistrationServiceImpl;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationServiceImpl registrationService;

    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/sign_up")
    public ModelAndView displayRegistrationPage(ModelAndView modelAndView){
        /*model.addAttribute("registrationDataDTO", new RegistrationDataDTO());
        model.addAttribute("roles", Role.values());*/
        modelAndView.addObject("registrationDataDTO", new RegistrationDataDTO());
        modelAndView.addObject("roles", Role.values());
        modelAndView.setViewName("/register/sign_up");
        return modelAndView;
    }
    @PostMapping("/sign_up")
    public ModelAndView processRegistrationForm(@ModelAttribute("registrationDataDTO") @Valid RegistrationDataDTO registrationDataDTO
            , BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest request) throws MessagingException {
        if(bindingResult.hasErrors()){
             modelAndView.setViewName("/register/sign_up");
             return modelAndView;
        }
        registrationService.register(registrationDataDTO, request);
        modelAndView.setViewName("redirect:/register/success");
        return modelAndView;
    }
    @GetMapping("/success")
    public String registrationSuccessPage(){
        return "/register/success";
    }
    @GetMapping("/verifyToken")
    public String verifyToken(@RequestParam String token){
        return "";
    }
}
