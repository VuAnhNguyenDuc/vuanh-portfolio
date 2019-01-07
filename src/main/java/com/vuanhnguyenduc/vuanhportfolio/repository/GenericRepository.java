package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.GenericModel;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Serializable> {

}
