package com.vuanhnguyenduc.vuanhportfolio.dto;

import com.vuanhnguyenduc.vuanhportfolio.model.Document;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class DocumentDTO implements Serializable {
    private Long id;

    @Length(min = 5, message = "Title cannot be lower than 5 characters")
    private String title;

    @NotBlank(message = "Mandatory Field")
    private String coverSrc;

    private String content;
    private Long albumId;
    private String albumName;
    private Date createdAt;
    private Date updatedAt;
    private String titleUrl;

    public DocumentDTO() {
    }

    public DocumentDTO(Document document) {
        this.id = document.getId();
        this.title = document.getTitle();
        this.coverSrc = document.getCoverSrc();
        this.content = document.getContent();
        this.createdAt = document.getCreatedAt();
        this.updatedAt = document.getUpdatedAt();
        this.titleUrl = document.getTitle().toLowerCase().replaceAll(" ","-");
        if(document.getAlbum() != null){
            this.albumId = document.getAlbum().getId();
            this.albumName = document.getAlbum().getTitle();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverSrc() {
        return coverSrc;
    }

    public void setCoverSrc(String coverSrc) {
        this.coverSrc = coverSrc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }
}
