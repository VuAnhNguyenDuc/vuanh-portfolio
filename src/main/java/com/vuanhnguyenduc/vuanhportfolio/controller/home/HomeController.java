package com.vuanhnguyenduc.vuanhportfolio.controller.home;

import com.vuanhnguyenduc.vuanhportfolio.commons.Constants;
import com.vuanhnguyenduc.vuanhportfolio.model.Role;
import com.vuanhnguyenduc.vuanhportfolio.model.User;
import com.vuanhnguyenduc.vuanhportfolio.repository.RoleRepository;
import com.vuanhnguyenduc.vuanhportfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashSet;

@Controller
public class HomeController {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"/","/index.html"})
    public String homePage(Model model){
        return Constants.HOME_PAGE;
    }

    @GetMapping("/about.html")
    public String aboutPage(Model model){
        return Constants.ABOUT_PAGE;
    }

    @GetMapping("/portfolio.html")
    public String portfolioPage(Model model){
        return Constants.PORTFOLIO_PAGE;
    }

    @GetMapping("/resume.html")
    public String resumePage(Model model){
        return Constants.RESUME_PAGE;
    }

    @GetMapping("/populateData")
    public String populateData(){
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");

        Role userRole = new Role();
        userRole.setRole("USER");

        if(roleRepository.findByRole(adminRole.getRole()) == null){
            roleRepository.save(adminRole);
        }
        if(roleRepository.findByRole(userRole.getRole()) == null){
            roleRepository.save(userRole);
        }

        User admin = new User();
        admin.setEmail("admin@vuanh.com");
        if(userRepository.findUserByEmail(admin.getEmail()) == null){
            admin.setPassword(bCryptPasswordEncoder.encode("ThomasHunt2412"));
            admin.setFirstName("Vu Anh");
            admin.setLastName("Nguyen Duc");
            admin.setActive(1);
            admin.setRoles(new HashSet<>(Arrays.asList(adminRole,userRole)));
            userRepository.save(admin);
        }


        User visitor = new User();
        visitor.setEmail("visitor@vuanh.com");
        if(userRepository.findUserByEmail(visitor.getEmail()) == null){
            visitor.setPassword(bCryptPasswordEncoder.encode("visitor"));
            visitor.setFirstName("Visitor");
            visitor.setLastName("Guest");
            visitor.setActive(1);
            visitor.setRoles(new HashSet<>(Arrays.asList(userRole)));
            userRepository.save(visitor);
        }

        return "redirect:/login.html";
    }
}
