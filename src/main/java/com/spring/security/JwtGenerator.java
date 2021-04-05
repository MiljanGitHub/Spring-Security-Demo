package com.spring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.security.model.JwtUser;






@Component
public class JwtGenerator {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private long expiration;
	
    public String generate(JwtUser jwtUser) {
    	
        Claims claims = Jwts.claims();
        
        claims.put("id", String.valueOf(jwtUser.getId()));
        claims.put("iat", System.currentTimeMillis());
        claims.put("exp", ((long) claims.get("iat")) + expiration);
        claims.put("random", jwtUser.getRandom());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    

}

