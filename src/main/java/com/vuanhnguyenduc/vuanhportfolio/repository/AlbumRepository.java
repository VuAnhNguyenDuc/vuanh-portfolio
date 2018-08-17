package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long>{
    Album findByTitle(String title);
}
