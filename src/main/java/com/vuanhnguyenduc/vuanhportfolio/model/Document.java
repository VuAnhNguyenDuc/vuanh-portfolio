package com.vuanhnguyenduc.vuanhportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt",""})
public class Document {

    //

}
