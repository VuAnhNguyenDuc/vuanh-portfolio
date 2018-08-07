package com.vuanhnguyenduc.vuanhportfolio.controller;

import com.vuanhnguyenduc.vuanhportfolio.model.File;
import com.vuanhnguyenduc.vuanhportfolio.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {
    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/insertFiles.html")
    private String insertFileForm(Model model){
        model.addAttribute("file", new File());
        return "/file/insert";
    }

    @PostMapping("/insertFiles.html")
    private String insertFileSubmit(@ModelAttribute File file){
        fileRepository.save(file);
        return "index";
    }
}
