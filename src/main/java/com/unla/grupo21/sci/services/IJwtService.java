package com.unla.grupo21.sci.services;

import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unla.grupo21.sci.dtos.TokenResponseDto;

public interface IJwtService {
	/**
	 * 
	 * Este método se encarga de generar un Json Web Token
	 * a partir de un objeto de Autenticación
	 * 
	 * @param authentication
	 * @return TokenResponse
	 * @throws JsonProcessingException
	 */
	public TokenResponseDto generateToken(Authentication authentication) throws JsonProcessingException;

}
