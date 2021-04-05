package com.spring.security;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.entity.model.User;
import com.spring.security.model.JwtUser;
import com.spring.security.model.JwtUserDetails;
import com.spring.security.repository.UserRepository;




@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  private JwtUser jwtUser;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    
	User user = userRepo.getOne(Integer.valueOf(id));
	
	return Optional.ofNullable(user).map(u -> JwtUserDetails.builder()
															.id(jwtUser.getId())
															.random(jwtUser.getRandom())
															.token(jwtUser.getToken())
															.authorities(getAuth(u))
															.build())
									.orElseThrow(IllegalArgumentException::new);

  }
  
  public void setJwtUser(JwtUser jwtUser) {
	  this.jwtUser = jwtUser;
  }
  
  private Collection<? extends GrantedAuthority> getAuth(User u){

	  return AuthorityUtils.createAuthorityList(u.getUserAuthorities()
			  									 .stream()
			  									 .flatMap(usersAuthority -> Stream.of(String.valueOf(usersAuthority.getAuthority().getUserRole())))
			  									 .toArray(String[]::new));
  }

}