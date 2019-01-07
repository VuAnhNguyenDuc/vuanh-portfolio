package com.vuanhnguyenduc.vuanhportfolio.dto;

import com.vuanhnguyenduc.vuanhportfolio.model.Blog;
import com.vuanhnguyenduc.vuanhportfolio.model.File;
import java.io.Serializable;

public class BlogDTO implements Serializable{
  private Long id;

  private String title;

  private String subTitle;

  private File coverImage;

  private String description;

  private String link;

  public BlogDTO() {
  }

  public BlogDTO(String title, String subTitle,
      File coverImage, String description, String link) {
    this.title = title;
    this.subTitle = subTitle;
    this.coverImage = coverImage;
    this.description = description;
    this.link = link;
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

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public File getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(File coverImage) {
    this.coverImage = coverImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
