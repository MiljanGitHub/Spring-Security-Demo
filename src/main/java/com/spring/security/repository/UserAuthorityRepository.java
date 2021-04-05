package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.model.UserAuthority;


@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {
	

	
}
