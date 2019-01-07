package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.dto.GenericDTO;
import com.vuanhnguyenduc.vuanhportfolio.model.GenericModel;
import com.vuanhnguyenduc.vuanhportfolio.repository.GenericRepository;
import com.vuanhnguyenduc.vuanhportfolio.utils.ObjectMapperUtils;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public class GenericController<T extends GenericModel, D extends GenericDTO> {
  @Autowired
  private GenericRepository<T> repository;

  protected String getPage;
  protected String createPage;
  protected String updatePage;
  protected String entityObj;
  protected String entities;
  protected String redirect;

  //https://www.baeldung.com/find-list-element-java
  public T findByTitle(String title) {
    List<T> all = repository.findAll();
    return all.stream().filter(x -> x.getTitle().equals(title)).findAny().orElse(null);
  }

  public String getPage(Model model){
    model.addAttribute(entities,repository.findAll());
    return getPage;
  }

  public String createPage(Model model, D dto) {
    model.addAttribute(entityObj,dto);
    return createPage;
  }

  public String create(T entity,D dto, BindingResult result, Model model) {
    T element = findByTitle(entity.getTitle());
    if (element != null) {
      result.rejectValue("title","error.entity.existed","An entity with the same title existed!");
    }

    return insertUpdate(entity,dto,result,model,true);
  }

  public String updatePage(Model model,D dto) {
    model.addAttribute(entityObj,dto);
    return updatePage;
  }

  public String update(T entity,D dto, BindingResult result, Model model) {
    return insertUpdate(entity,dto,result,model,false);
  }

  private String insertUpdate(T entity,D dto, BindingResult result, Model model, boolean insert) {
    if(result.hasErrors()){
      model.addAttribute(entityObj,dto);
      return insert?createPage : updatePage;
    } else{
      repository.save(entity);
      return redirect;
    }
  }
}
