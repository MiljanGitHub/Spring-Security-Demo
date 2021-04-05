package com.spring.security.service;

import com.spring.security.entity.model.UserAuthority;

public interface UserAuthorityService {
	
	UserAuthority save(UserAuthority userAuthority);
	UserAuthority findById(int userAuthorityId);

}
