package com.spring.security.service;

import com.spring.security.entity.model.Authority;
import com.spring.security.entity.model.UserRole;

public interface AuthorityService {
	
	Authority save(Authority authority);
	Authority findByUserRole(UserRole userRole);
}
