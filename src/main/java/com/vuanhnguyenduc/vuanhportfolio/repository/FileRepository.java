package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Long> {
    File getByCloudSrc(String src);
    File getByTitle(String title);
    List<File> findByType(String type);
}
