package com.unla.grupo21.sci.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unla.grupo21.sci.dtos.TokenResponseDto;
import com.unla.grupo21.sci.services.IJwtService;
import com.unla.grupo21.sci.services.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IJwtService jwtService;

	@Override
	public TokenResponseDto login(String usuario, String clave) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario, clave);

		try {
			Authentication authentication = authenticationManager.authenticate(token);
			return jwtService.generateToken(authentication);

		} catch (AuthenticationException | JsonProcessingException e) {
			throw new AuthenticationCredentialsNotFoundException(e.getMessage());
		}
	}
}
