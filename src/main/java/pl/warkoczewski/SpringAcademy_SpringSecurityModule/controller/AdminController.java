package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/admin")
    public String adminPage(){
        return "/admin/admin";
    }
    @GetMapping("/admin/adminHead")
    public String adminHeadPage(){
        return "/admin/adminHead";
    }
}
