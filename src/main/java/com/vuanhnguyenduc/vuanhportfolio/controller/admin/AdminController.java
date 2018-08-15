package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.model.User;
import com.vuanhnguyenduc.vuanhportfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String adminPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        if(user != null){
            model.addAttribute("greetings", String.format("Welcome %s %s",user.getFirstName(),user.getLastName()));
        }
        return "admin/index";
    }

    @GetMapping("/login.html")
    public String loginPage(Model model){
        return "admin/login";
    }

    @GetMapping("/register.html")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "admin/register";
    }

    @PostMapping("/register.html")
    public String createUser(@Valid User user, BindingResult result, Model model){
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists != null) {
            result.rejectValue("email","error.user","A user with the same email has registered");
        }

        if(result.hasErrors()){
            return "admin/register";
        } else {
            userService.saveUser(user);
            return "redirect:/login.html";
        }
    }

    @GetMapping("/403")
    public String error403Page(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",authentication.getName());
        return "error/403";
    }

}
