package com.spring.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.security.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	@Value("${jwt.secret}")
    private String secret;

	@Value("${jwt.expiration}")
	private long expiration;
	
    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            
            if (tokenExpired(body)) return null;
            
            jwtUser = new JwtUser();

            jwtUser.setId(Integer.parseInt((String) body.get("id")));
            jwtUser.setRandom((String) body.get("random"));
            jwtUser.setToken(token);
            
        } catch (Exception e) {
        	
            System.out.println(e);
            return null;
        }

        return jwtUser;
    }
    
	private boolean tokenExpired(Claims claims) {
		
	    return (System.currentTimeMillis() - ((long) claims.get("iat"))) >= expiration;
	}
}


