package com.vuanhnguyenduc.service;

import com.vuanhnguyenduc.model.UserProfile;
import java.util.List;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
