package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.dto.DocumentDTO;
import com.vuanhnguyenduc.vuanhportfolio.model.Album;
import com.vuanhnguyenduc.vuanhportfolio.model.Document;
import com.vuanhnguyenduc.vuanhportfolio.repository.AlbumRepository;
import com.vuanhnguyenduc.vuanhportfolio.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping(name = "/admin")
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    AlbumRepository albumRepository;

    private static final String GET_PAGE = "admin/document/get";
    private static final String CREATE_PAGE = "admin/document/create";
    private static final String UPDATE_PAGE = "admin/document/update";
    private static final String DOCUMENT = "document";
    private static final String DOCUMENTS = "documents";
    private static final String REDIRECT_DOCUMENT = "redirect:/admin/documents";

    @GetMapping("/documents")
    public String getDocuments(Model model){
        List<Document> documents = documentRepository.findAll();
        List<DocumentDTO> documentDTOS = new ArrayList<>();
        for(Document document : documents){
            DocumentDTO documentDTO = new DocumentDTO(document);
            documentDTOS.add(documentDTO);
        }
        model.addAttribute(DOCUMENTS,documentDTOS);
        return GET_PAGE;
    }

    @GetMapping("/createDocument")
    public String createPage(Model model){
        model.addAttribute(DOCUMENT, new DocumentDTO());
        return CREATE_PAGE;
    }

    @PostMapping("/createDocument")
    public String create(@Valid DocumentDTO documentDTO, BindingResult result, Model model){
        Document doc = documentRepository.getByTitle(documentDTO.getTitle());
        if(doc != null) {
            result.rejectValue("title","error.document","The document with the same title already existed");
        }

        if(result.hasErrors()){
            model.addAttribute(DOCUMENT,documentDTO);
            return CREATE_PAGE;
        } else{
            Document document = new Document();
            map(documentDTO,document);
            documentRepository.save(document);
            return REDIRECT_DOCUMENT;
        }
    }

    @GetMapping("/updateDocument/{title}/{id}")
    public String updatePage(@PathVariable Integer id, Model model){
        Document document = documentRepository.getOne(Long.valueOf(id));
        model.addAttribute(DOCUMENT,new DocumentDTO(document));
        return UPDATE_PAGE;
    }

    @PostMapping("/updateDocument/{title}/{id}")
    public String update(@Valid DocumentDTO documentDTO, BindingResult result, Model model, @PathVariable Integer id){
        if (result.hasErrors()){
            model.addAttribute(DOCUMENT,documentDTO);
            return UPDATE_PAGE;
        } else{
            Document document = documentRepository.getOne(Long.valueOf(id));
            map(documentDTO,document);
            documentRepository.save(document);
            return REDIRECT_DOCUMENT;
        }
    }

    @ModelAttribute("albums")
    public Map<Long,String> getAlbums(){
        List<Album> albums = albumRepository.findAll();
        HashMap<Long,String> result = new HashMap<>();
        for(Album album : albums){
            result.put(album.getId(),album.getTitle());
        }
        return result;
    }

    private void map(DocumentDTO documentDTO, Document document){
        document.setTitle(documentDTO.getTitle());
        document.setContent(documentDTO.getContent());
        document.setCoverSrc(documentDTO.getCoverSrc());
        document.setAlbum(albumRepository.getOne(documentDTO.getAlbumId()));
    }
}
