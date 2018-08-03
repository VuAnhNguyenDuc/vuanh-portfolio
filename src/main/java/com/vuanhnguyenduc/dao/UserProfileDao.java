package com.vuanhnguyenduc.dao;

import com.vuanhnguyenduc.model.UserProfile;
import java.util.List;


public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
