package com.vuanhnguyenduc.vuanhportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "PROJECT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
public class Project implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "IMAGES")
  private Set<File> images;

  @Column(name = "TAGS")
  private Set<Tag> tags;

  @Column(name = "SUB_TITLE")
  private String subTitle;

  @Column(name = "DESCRIPTION")
  private String description;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<File> getImages() {
    return images;
  }

  public void setImages(Set<File> images) {
    this.images = images;
  }

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
