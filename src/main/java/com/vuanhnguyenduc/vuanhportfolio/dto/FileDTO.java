package com.vuanhnguyenduc.vuanhportfolio.dto;

import com.vuanhnguyenduc.vuanhportfolio.model.File;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class FileDTO implements Serializable{
    private Long id;
    @NotBlank(message = "Mandatory Field")
    private String title;
    private String description;
    @NotBlank(message = "Mandatory Field")
    private String cloudSrc;
    private String thumbnailSrc;
    private String type;
    private Date createdAt;
    private Date updatedAt;
    private String titleUrl;

    public FileDTO() {
    }

    // Create an FileDTO Object From a File Object
    public FileDTO(File file) {
        this.id = file.getId();
        this.title = file.getTitle();
        this.description = file.getDescription();
        this.cloudSrc = file.getCloudSrc();
        this.thumbnailSrc = file.getThumbnailSrc();
        this.type = file.getType();
        this.createdAt = file.getCreatedAt();
        this.updatedAt = file.getUpdatedAt();
        this.titleUrl = title.toLowerCase().replaceAll(" ","-");
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCloudSrc() {
        return cloudSrc;
    }

    public void setCloudSrc(String cloudSrc) {
        this.cloudSrc = cloudSrc;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
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

    public String getThumbnailSrc() {
        return thumbnailSrc;
    }

    public void setThumbnailSrc(String thumbnailSrc) {
        this.thumbnailSrc = thumbnailSrc;
    }
}
