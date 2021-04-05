package com.spring.security.dto;



import com.spring.security.entity.model.UserRole;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder
public class RegisterRequest {
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String accountNo;
    private int model;
    private String personalNumber;
    private UserRole userType;
    
   
}
