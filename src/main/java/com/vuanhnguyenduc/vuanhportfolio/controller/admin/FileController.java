package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.dto.FileDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @Autowired


    private static final String CREATE_PAGE = "admin/file/create";
    private static final String UPDATE_PAGE = "admin/file/update";

    @GetMapping("/files")
    public String getFiles(Model model){
        List<File> files = fileRepository.findAll();
        List<FileDTO> fileDTOS = new ArrayList<>();
        for(File file : files){
            fileDTOS.add(new FileDTO(file));
        }
        model.addAttribute("files",fileDTOS);
        return "admin/file/get";
    }

    @GetMapping("/createFile")
    public String createPage(Model model){
        FileDTO file = new FileDTO();
        model.addAttribute("file",file);
        return CREATE_PAGE;
    }

    @PostMapping("/createFile")
    public String create(@Valid FileDTO fileDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("file",fileDTO);
            return CREATE_PAGE;
        } else{
            File file = new File();
            file.map(fileDTO);
            return checkForValidFile(file,result);
        }
    }

    @GetMapping("/updateFile/{title}/{id}")
    public String updatePage(@PathVariable int id, Model model){
        File file = fileRepository.getOne((long) id);
        FileDTO fileDTO = new FileDTO(file);
        model.addAttribute("file",fileDTO);
        return UPDATE_PAGE;
    }

    @PostMapping("/updateFile/{id}")
    public String update(@Valid FileDTO fileDTO, BindingResult result,@PathVariable int id, Model model){
        if(result.hasErrors()){
            model.addAttribute("file",fileDTO);
            return UPDATE_PAGE;
        } else{
            File file = fileRepository.getOne((long) id);
            file.map(fileDTO);
            return checkForValidFile(file,result);
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
