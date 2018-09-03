package com.vuanhnguyenduc.vuanhportfolio.dto;

import com.vuanhnguyenduc.vuanhportfolio.model.Album;
import com.vuanhnguyenduc.vuanhportfolio.model.Document;
import com.vuanhnguyenduc.vuanhportfolio.model.File;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class AlbumDTO implements Serializable {
    private Long id;
    private String coverSrc;
    private String title;
    private String description;
    private Set<File> files;
    private Set<Document> documents;
    private Date createdAt;
    private Date updatedAt;
    private String titleUrl;

    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.coverSrc = album.getCoverSrc();
        this.title = album.getTitle();
        this.description = album.getDescription();
        this.files = album.getFiles();
        this.documents = album.getDocuments();
        this.createdAt = album.getCreatedAt();
        this.updatedAt = album.getUpdatedAt();
        this.titleUrl = album.getTitle().toLowerCase().replaceAll(" ","-");
    }

    public AlbumDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoverSrc() {
        return coverSrc;
    }

    public void setCoverSrc(String coverSrc) {
        this.coverSrc = coverSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
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
