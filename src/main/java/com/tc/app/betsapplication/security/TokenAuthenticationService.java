package com.tc.app.betsapplication.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static java.util.Collections.emptyList;

public class TokenAuthenticationService {
/**
 * Method to add the JWT token on response header
 * @param res
 * @param username
 */
	static void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).compact();
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + " " + JWT);
	}

	/**
	 * Static method to read JWT token from request and validate the token
	 * 
	 * @param request
	 * @return
	 */
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody().getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}
