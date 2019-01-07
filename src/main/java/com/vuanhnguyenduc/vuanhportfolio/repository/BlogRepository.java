package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.Blog;

public interface BlogRepository extends GenericRepository<Blog>{
  Blog findByTitle(String title);
}
