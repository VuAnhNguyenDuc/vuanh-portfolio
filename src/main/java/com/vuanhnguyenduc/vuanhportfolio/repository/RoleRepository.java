package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByRole(String role);
}
