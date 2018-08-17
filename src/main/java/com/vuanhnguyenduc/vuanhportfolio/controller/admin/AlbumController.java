package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.model.Album;
import com.vuanhnguyenduc.vuanhportfolio.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAlbums(){
        return "admin/album/get";
    }

    @GetMapping("/createAlbum")
    public String createPage(Model model){
        model.addAttribute("album", new Album());
        return "admin/album/create";
    }

    @PostMapping("/createAlbum")
    public String create(@Valid Album album, BindingResult result, Model model){
        Album al = albumRepository.findByTitle(album.getTitle());
        if(al != null){
            result.rejectValue("title","error.album","An album with the same title existed!");
        }

        if(result.hasErrors()){
            model.addAttribute("album",album);
            return "admin/album/create";
        } else{
            albumRepository.save(album);
            return "redirect:/albums";
        }
    }
}
