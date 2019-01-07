package com.vuanhnguyenduc.vuanhportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "BLOG")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
public class Blog implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "BLOG_ID", nullable = false)
  private Long id;

  @Column(name = "TITLE", nullable = false)
  private String title;

  @Column(name = "SUB_TITLE")
  private String subTitle;

  @Column(name = "COVER_IMAGE", nullable = false)
  private File coverImage;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "LINK", nullable = false)
  private String link;

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
