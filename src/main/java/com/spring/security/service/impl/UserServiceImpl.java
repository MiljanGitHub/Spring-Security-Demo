package com.spring.security.service.impl;

import org.springframework.stereotype.Service;

import com.spring.security.entity.model.User;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository repository;
	
	public UserServiceImpl (UserRepository repository){
		this.repository = repository;
	}

	@Override
	public User findById(int userId) {
		return repository.getOne(userId);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(int userId) {
		repository.deleteById(userId);
		
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

}

