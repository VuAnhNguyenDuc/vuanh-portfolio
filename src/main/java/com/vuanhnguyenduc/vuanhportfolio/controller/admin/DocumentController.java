package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.model.Document;
import com.vuanhnguyenduc.vuanhportfolio.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/documents")
    public String getDocuments(Model model){
        return "admin/document/get";
    }

    @GetMapping("/createDocument")
    public String createPage(Model model){
        model.addAttribute("document", new Document());
        return "admin/document/create";
    }

    @PostMapping("/createDocument")
    public String create(@Valid Document document, BindingResult result, Model model){
        Document doc = documentRepository.getByTitle(document.getTitle());
        if(doc != null) {
            result.rejectValue("title","error.document","The document with the same title already existed");
        }

        if(result.hasErrors()){
            model.addAttribute("document",document);
            return "admin/file/create";
        } else{
            documentRepository.save(document);
            return "redirect:/documents";
        }
    }

    @GetMapping("/updateDocument/{id}/{title}.html")
    public String updatePage(@PathVariable Integer id, Model model){
        Document document = documentRepository.getOne(Long.valueOf(id));
        model.addAttribute("document",document);
        return "admin/document/update";
    }

    @PostMapping("/updateDocument/{id}/{title}.html")
    public String update(@Valid Document document, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("document",document);
            return "admin/document/update";
        } else{
            documentRepository.save(document);
            return "redirect:/documents";
        }
    }
}
