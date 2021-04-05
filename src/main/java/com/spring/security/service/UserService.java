package com.spring.security.service;

import com.spring.security.entity.model.User;

public interface UserService {
	
	User findById(int userId);
	User save(User user);
	void delete(int userId);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
