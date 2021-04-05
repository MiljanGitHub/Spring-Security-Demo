package com.spring.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;


	private String token;
	private int id;
	private String random;

	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(String token, int id, String random, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.id = id;
		this.random = random;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getToken() {
		return token;
	}

	public int getId() {
		return id;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

}
