package com.vuanhnguyenduc.vuanhportfolio.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/index.html"})
    public String homePage(Model model){
        return "home/index";
    }

    @GetMapping("/about.html")
    public String aboutPage(Model model){
        return "home/about";
    }

    @GetMapping("/portfolio.html")
    public String portfolioPage(Model model){
        return "home/portfolio";
    }

    @GetMapping("/resume.html")
    public String resumePage(Model model){
        return "home/resume";
    }
}
