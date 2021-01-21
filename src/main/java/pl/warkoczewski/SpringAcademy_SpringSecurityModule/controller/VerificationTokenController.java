package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.service.VerificationTokenService;

@Controller
@RequestMapping("/verify")
public class VerificationTokenController {
    private final VerificationTokenService verificationTokenService;

    public VerificationTokenController(VerificationTokenService verificationTokenService) {
        this.verificationTokenService = verificationTokenService;
    }
    @GetMapping("/verifyUserToken")
    public String verifyUserToken(@RequestParam String token){
        verificationTokenService.verifyUserToken(token);
        return "redirect:/login/sign_in";
    }
    @GetMapping("/verifyAdminToken")
    public String verifyAdminToken(@RequestParam String token){
        verificationTokenService.verifyAdminToken(token);
        return "redirect:/login/sign_in";
    }
}
