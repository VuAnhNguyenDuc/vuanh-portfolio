package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.model.File;
import com.vuanhnguyenduc.vuanhportfolio.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class FileController {
    @Autowired
    FileRepository fileRepository;

    private static final String CREATE_PAGE = "admin/file/create";
    private static final String UPDATE_PAGE = "admin/file/update";

    @GetMapping("/files")
    public String getFiles(){
        return "admin/file/get";
    }

    @GetMapping("/createFile")
    public String createPage(Model model){
        File file = new File();
        model.addAttribute("file",file);
        return CREATE_PAGE;
    }

    @PostMapping("/createFile")
    public String create(@Valid File file, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("file",file);
            return CREATE_PAGE;
        } else{
            return checkForValidFile(file,result);
        }
    }

    @GetMapping("/updateFile/file-id-{id}")
    public String updatePage(@PathVariable Integer id, Model model){
        File file = fileRepository.getOne(Long.valueOf(id));
        model.addAttribute("file",file);
        return UPDATE_PAGE;
    }

    @PostMapping("/updateFile")
    public String update(@Valid File file, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("file",file);
            return UPDATE_PAGE;
        } else{
            return checkForValidFile(file,result);
        }
    }

    private String checkForValidFile(File file, BindingResult result){
        File checkBySrc = fileRepository.getByCloudSrc(file.getCloudSrc());
        if(checkBySrc != null){
            result.rejectValue("cloudSrc","error.file","A file with the same source already existed!");
            return CREATE_PAGE;
        }

        File checkByTitle = fileRepository.getByTitle(file.getTitle());
        if(checkByTitle != null){
            result.rejectValue("title","error.file","A file with the same title already existed!");
            return CREATE_PAGE;
        }

        fileRepository.save(file);
        return "redirect:/files";
    }
}
