package com.vuanhnguyenduc.vuanhportfolio.repository;

import com.vuanhnguyenduc.vuanhportfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
