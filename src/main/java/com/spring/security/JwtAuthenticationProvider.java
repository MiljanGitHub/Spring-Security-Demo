package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.spring.security.model.JwtAuthenticationToken;
import com.spring.security.model.JwtUser;
import com.spring.security.model.JwtUserDetails;







@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	private JwtValidator validator;
	
	@Autowired
	private JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		
		String token = jwtAuthenticationToken.getToken();

		JwtUser jwtUser = validator.validate(token);
		
		if (jwtUser == null) {
			throw new BadCredentialsException("JSON Web token is incorrect!");
		}
		
		jwtUserDetailsServiceImpl.setJwtUser(jwtUser);

		JwtUserDetails userDetails = (JwtUserDetails) jwtUserDetailsServiceImpl.loadUserByUsername(String.valueOf(jwtUser.getId()));

		return userDetails;
	}

	@Override
	public boolean supports(Class<?> aClass) {

		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));

	}

}


