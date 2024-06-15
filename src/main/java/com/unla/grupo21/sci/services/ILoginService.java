package com.unla.grupo21.sci.services;

import org.springframework.security.core.AuthenticationException;

import com.unla.grupo21.sci.dtos.TokenResponseDto;

public interface ILoginService {

	/**
	 * Realiza el proceso de autenticacion mediante el AuthenticationManager,
	 * compara las credenciales contra la base de datos
	 * 
	 * @param usuario El usuario
	 * @param clave   La contraseña
	 * @return El token de respuesta si la autenticacion es exitosa
	 * @throws AuthenticationException Si hay algun problema al autenticar
	 */
	public TokenResponseDto login(String usuario, String clave);
}
