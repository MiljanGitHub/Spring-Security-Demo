package com.spring.security.controller.impl;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.JwtGenerator;
import com.spring.security.dto.RegisterRequest;
import com.spring.security.entity.model.User;
import com.spring.security.model.JwtUser;
import com.spring.security.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserControllerImpl {
	


	private UserService userService;
	private JwtGenerator jwtGenerator;
	private PasswordEncoder encoder;
	
	public ResponseEntity<String> register(RegisterRequest registerRequest, Object obj){ 
		
		ResponseEntity<String> response = null;
		
		//some register logic
		
		return response;
	}
	
	public ResponseEntity<String> login(String username, String password){
		
		System.out.print(encoder.encode(password));
		
		User user = userService.findByUsername(username); 

		if (user == null || !encoder.matches(password, user.getPassword())) {
			return ResponseEntity
					.ok()
					.header("error", "true")
					.body("message");
		}
	

		String random = String.format("%04d", new Random().nextInt(10000));
	
		JwtUser jwtUser = JwtUser.builder()
								.id(user.getId())
								.random(random)
								.build();
		
		String jwt = jwtGenerator.generate(jwtUser);
	
	return ResponseEntity
			.ok()
			.header("error", "false")
			.header("roles")
			.body(jwt);
		

	}
	
}
