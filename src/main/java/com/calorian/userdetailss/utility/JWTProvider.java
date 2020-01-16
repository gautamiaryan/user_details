package com.calorian.userdetailss.utility;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTProvider {
	
	private final String secret = "Aishwarya";

	public String generateToken(String emailId) {
		return JWT.create().withClaim("email", emailId).sign(Algorithm.HMAC512(secret));
	}

	public String parseToken(String token) {
		return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getClaim("email").asString();
	}

}
