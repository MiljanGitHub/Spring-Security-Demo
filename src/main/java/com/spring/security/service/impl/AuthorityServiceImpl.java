package com.spring.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.entity.model.Authority;
import com.spring.security.entity.model.UserRole;
import com.spring.security.repository.AuthorityRepository;
import com.spring.security.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository repository;
	
	@Override
	public Authority save(Authority authority) {
		return repository.save(authority);
	}

	@Override
	public Authority findByUserRole(UserRole userRole) {
		return repository.findByUserRole(userRole);
	}

}
