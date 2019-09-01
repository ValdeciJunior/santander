package br.com.santander.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expire}")
	private long expire;
	
	public String generateToken(String username) {
		System.out.println(secret);
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expire))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
}
