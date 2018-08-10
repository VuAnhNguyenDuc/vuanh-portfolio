package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    @GetMapping("/admin.html")
    public String adminPage(Model model){
        return "admin/index";
    }

    @GetMapping("/login.html")
    public String loginPage(Model model){
        return "admin/login";
    }

    @GetMapping("/403")
    public String error403Page(){
        return "error/403";
    }

}
