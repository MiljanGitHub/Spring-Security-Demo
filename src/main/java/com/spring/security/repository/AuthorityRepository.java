package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.model.Authority;
import com.spring.security.entity.model.UserRole;



@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{
	
	Authority findByUserRole(UserRole userRole);
}

