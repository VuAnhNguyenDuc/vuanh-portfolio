package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.dto.AlbumDTO;
import com.vuanhnguyenduc.vuanhportfolio.model.Album;
import com.vuanhnguyenduc.vuanhportfolio.model.Document;
import com.vuanhnguyenduc.vuanhportfolio.model.File;
import com.vuanhnguyenduc.vuanhportfolio.repository.AlbumRepository;
import com.vuanhnguyenduc.vuanhportfolio.repository.DocumentRepository;
import com.vuanhnguyenduc.vuanhportfolio.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlbumController {
    private static final String GET_PAGE = "admin/album/get";
    private static final String CREATE_PAGE = "admin/album/create";
    private static final String UPDATE_PAGE = "admin/album/update";
    private static final String ALBUM = "album";
    private static final String ALBUMS = "albums";
    private static final String REDIRECT_ALBUM = "redirect:/admin/albums";

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/admin/albums")
    public String getAlbums(Model model){
        List<Album> albums = albumRepository.findAll();
        List<AlbumDTO> albumDTOS = new ArrayList<>();
        for(Album album : albums){
            albumDTOS.add(new AlbumDTO(album));
        }
        model.addAttribute(ALBUMS,albumDTOS);
        return GET_PAGE;
    }

    @GetMapping("/admin/createAlbum")
    public String createPage(Model model){
        model.addAttribute(ALBUM, new AlbumDTO());
        return CREATE_PAGE;
    }

    @PostMapping("/admin/createAlbum")
    public String create(@Valid @ModelAttribute(ALBUM) AlbumDTO albumDTO, BindingResult result, Model model){
        Album album = albumRepository.findByTitle(albumDTO.getTitle());
        if(album != null){
            result.rejectValue("title","error.album","An album with the same title existed!");
        }

        if(result.hasErrors()){
            model.addAttribute(ALBUM,albumDTO);
            return CREATE_PAGE;
        } else{
            album = new Album();
            map(albumDTO,album);
            albumRepository.save(album);
            return REDIRECT_ALBUM;
        }
    }

    @GetMapping("/admin/updateAlbum/{title}/{id}")
    public String updatePage(Model model, @PathVariable Integer id){
        AlbumDTO albumDTO = new AlbumDTO(albumRepository.getOne(Long.valueOf(id)));
        model.addAttribute(ALBUM,albumDTO);
        return UPDATE_PAGE;
    }

    @PostMapping("/admin/updateAlbum/{title}/{id}")
    public String update(@Valid @ModelAttribute(ALBUM) AlbumDTO albumDTO, BindingResult result, Model model, @PathVariable Integer id){
        if(result.hasErrors()){
            model.addAttribute(ALBUM,albumDTO);
            return UPDATE_PAGE;
        } else{
            Album album = albumRepository.getOne(Long.valueOf(id));
            map(albumDTO,album);
            albumRepository.save(album);
            return REDIRECT_ALBUM;
        }
    }

    private void map(AlbumDTO albumDTO, Album album){
        album.setTitle(albumDTO.getTitle());
        album.setCoverSrc(albumDTO.getCoverSrc());
        album.setDescription(albumDTO.getDescription());
        album.setDocuments(albumDTO.getDocuments());
        album.setImages(albumDTO.getImages());
        album.setDocs(albumDTO.getDocs());
        album.setVideos(albumDTO.getVideos());
    }

    @ModelAttribute("documents")
    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }

    @ModelAttribute("allImages")
    public List<File> getImages(){
        //HashMap<Integer,String> images = new HashMap<>();
        List<File> imageFiles = fileRepository.findByType("IMAGE");
        /*for(File image : imageFiles){
            images.put(Math.toIntExact(image.getId()),image.getCloudSrc());
        }*/
        return imageFiles;
    }

    @ModelAttribute("allVideos")
    public List<File> getVideos(){
        return fileRepository.findByType("VIDEO");
    }

    @ModelAttribute("allDocuments")
    public List<File> getDocumentsFiles(){
        return fileRepository.findByType("DOCUMENT");
    }

}
