package com.vuanhnguyenduc.vuanhportfolio.service;

import com.vuanhnguyenduc.vuanhportfolio.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
