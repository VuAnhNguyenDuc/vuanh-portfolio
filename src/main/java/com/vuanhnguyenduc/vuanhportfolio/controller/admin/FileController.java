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
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class FileController {
    @Autowired
    FileRepository fileRepository;

    private static final String CREATE_PAGE = "admin/file/create";
    private static final String UPDATE_PAGE = "admin/file/update";

    @GetMapping("/files")
    public String getFiles(Model model){
        model.addAttribute("files",fileRepository.findAll());
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

    @GetMapping("/updateFile/{title}/{id}")
    public String updatePage(@PathVariable int id, Model model){
        File file = fileRepository.getOne((long) id);
        //File file = fileRepository.findAll().get(0);
        model.addAttribute("file",file);
        return UPDATE_PAGE;
    }

    @PostMapping("/updateFile/{id}")
    public String update(@Valid File file, BindingResult result,@PathVariable int id, Model model){
        if(result.hasErrors()){
            model.addAttribute("file",file);
            return UPDATE_PAGE;
        } else{
            File oldFile = fileRepository.getOne((long) id);
            oldFile.setCloudSrc(file.getCloudSrc());
            oldFile.setDescription(file.getDescription());
            oldFile.setTitle(file.getTitle());
            oldFile.setType(file.getType());
            return checkForValidFile(oldFile,result);
        }
    }

    private String checkForValidFile(File file, BindingResult result){
        File checkBySrc = fileRepository.getByCloudSrc(file.getCloudSrc());
        if(checkBySrc != null && (file.getId() == null || !Objects.equals(file.getId(), checkBySrc.getId()))){
            result.rejectValue("cloudSrc","error.file","A file with the same source already existed!");
            return CREATE_PAGE;
        }

        File checkByTitle = fileRepository.getByTitle(file.getTitle());
        if(checkByTitle != null && (file.getId() == null || !Objects.equals(file.getId(), checkByTitle.getId()))){
            result.rejectValue("title","error.file","A file with the same title already existed!");
            return CREATE_PAGE;
        }

        fileRepository.save(file);
        return "redirect:/admin/files";
    }
}
