package com.spring.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.entity.model.UserAuthority;
import com.spring.security.repository.UserAuthorityRepository;
import com.spring.security.service.UserAuthorityService;



@Service
public class UserAuthorityServiceImpl implements UserAuthorityService{
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;

	@Override
	public UserAuthority save(UserAuthority userAuthority) {
		return userAuthorityRepository.save(userAuthority);
	}

	@Override
	public UserAuthority findById(int userAuthorityId) {
		return userAuthorityRepository.getOne(userAuthorityId);
	}

}
