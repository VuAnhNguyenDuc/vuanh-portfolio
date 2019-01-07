package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long>{
  Blog findByTitle(String title);
}
