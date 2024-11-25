package com.unla.grupo21.sci.services.impl;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.grupo21.sci.configuration.TokenJwtConfiguration;
import com.unla.grupo21.sci.dtos.TokenResponseDto;
import com.unla.grupo21.sci.services.IJwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService implements IJwtService {

	@Override
	public TokenResponseDto generateToken(Authentication authentication) throws JsonProcessingException {

		if (authentication == null || !authentication.isAuthenticated()) {
			throw new AuthenticationCredentialsNotFoundException("Not authenticated");
		}

		String usuario = ((User) authentication.getPrincipal()).getUsername();
		String authoritiesString = new ObjectMapper().writeValueAsString(authentication.getAuthorities());
		Claims claims = Jwts.claims().add("authorities", authoritiesString).build();
		String token = Jwts.builder().subject(usuario).signWith(TokenJwtConfiguration.SECRET_KEY).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + TokenJwtConfiguration.TOKEN_DURATION_SEGS))
				.claims(claims).compact();

		return TokenResponseDto.builder().token(token).usuario(usuario).build();

	}

}
