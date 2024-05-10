package com.unla.grupo21.sci.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Este service implementa una interfaz de Spring para poder autenticar. Debe
 * utilizar un repository para buscar los usuarios que estén registrados
 */
@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO: Implementar método para cargar un detalle de Usuario segun `username`
		return null;
	}

}
