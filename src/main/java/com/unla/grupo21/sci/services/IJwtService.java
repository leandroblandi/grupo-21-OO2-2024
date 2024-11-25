package com.unla.grupo21.sci.services;

import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unla.grupo21.sci.dtos.TokenResponseDto;

public interface IJwtService {
	/**
	 * Este método se encarga de generar un Json Web Token a partir de un objeto de
	 * Autenticación
	 * 
	 * @param authentication El objeto de autenticacion con los datos del usuario
	 * @return TokenResponse El objeto de respuesta con el token y el usuario
	 * @throws JsonProcessingException Si hay algun problema al obtener los datos
	 */
	public TokenResponseDto generateToken(Authentication authentication) throws JsonProcessingException;

}
