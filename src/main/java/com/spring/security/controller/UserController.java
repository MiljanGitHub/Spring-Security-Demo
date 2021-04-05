package com.spring.security.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.controller.impl.UserControllerImpl;
import com.spring.security.dto.RegisterRequest;




@RequestMapping("/spring-security")
@RestController
public class UserController {
	
	@Autowired
	private UserControllerImpl userControllerImpl;

	@PostMapping(value = "/register") //, consumes = {"multipart/form-data"}
	public ResponseEntity<String> register(RegisterRequest registerRequest){ //, List<MultipartFile> documents
		
		ResponseEntity<String> response = userControllerImpl.register(registerRequest, null);
		
		return response;
	}
	
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
		
		ResponseEntity<String> response = userControllerImpl.login(username, password);
		
		return response;
	}


	
}

