package com.vuanhnguyenduc.vuanhportfolio.controller.admin;

import com.vuanhnguyenduc.vuanhportfolio.dto.BlogDTO;
import com.vuanhnguyenduc.vuanhportfolio.model.Blog;
import com.vuanhnguyenduc.vuanhportfolio.repository.BlogRepository;
import com.vuanhnguyenduc.vuanhportfolio.utils.ObjectMapperUtils;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
  private static final String GET_PAGE = "admin/blog/get";
  private static final String CREATE_PAGE = "admin/blog/create";
  private static final String UPDATE_PAGE = "admin/blog/update";
  private static final String BLOG = "blog";
  private static final String REDIRECT_BLOG = "redirect:/admin/blog";

  @Autowired
  BlogRepository blogRepository;

  @GetMapping("/admin/blog")
  public String getBlog(Model model) {
    List<BlogDTO> blogDTOS = ObjectMapperUtils.mapAll(blogRepository.findAll(),BlogDTO.class);
    model.addAttribute("blog",blogDTOS);
    return GET_PAGE;
  }

  @GetMapping("/admin/createBlog")
  public String createPage(Model model) {
    model.addAttribute("blog", new BlogDTO());
    return CREATE_PAGE;
  }

  @PostMapping("/admin/createBlog")
  public String create(@Valid @ModelAttribute(BLOG) BlogDTO blogDTO, BindingResult result, Model model) {
    Blog blog = blogRepository.findByTitle(blogDTO.getTitle());
    if (blog != null) {
      result.rejectValue("title","error.blog","A blog with same title already existed!");
    }

    if (result.hasErrors()) {
      model.addAttribute(BLOG,blogDTO);
      return CREATE_PAGE;
    } else {
      blog = ObjectMapperUtils.map(blogDTO,Blog.class);
      blogRepository.save(blog);
      return REDIRECT_BLOG;
    }
  }
}
