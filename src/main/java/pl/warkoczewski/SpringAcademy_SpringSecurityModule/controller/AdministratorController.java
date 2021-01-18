package pl.warkoczewski.SpringAcademy_SpringSecurityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/admin")
public class AdministratorController {
    @GetMapping("/admin")
    public String displayAdminPage(){
        return "/admin/admin";
    }
    @GetMapping("/adminHead")
    public String displayAdminHeadPage(){
        return "/admin/adminHead";
    }
}
