package com.vuanhnguyenduc.vuanhportfolio.controller;

import com.vuanhnguyenduc.vuanhportfolio.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public String getAllNodes(ModelMap model){
        model.addAttribute("notes",noteRepository.findAll());
        return "notes";
    }

}
