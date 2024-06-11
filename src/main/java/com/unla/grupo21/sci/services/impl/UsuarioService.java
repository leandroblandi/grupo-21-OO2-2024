package com.unla.grupo21.sci.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.UsuarioRol;
import com.unla.grupo21.sci.repositories.IUsuarioRepository;
import com.unla.grupo21.sci.services.IUsuarioService;

/**
 * Este service implementa una interfaz de Spring para poder autenticar. Debe
 * utilizar un repository para buscar los usuarios que estén registrados
 */
@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(username);
		if(usuarioOptional.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		return buildUser(usuarioOptional.get());	
	}
	
	private User buildUser(Usuario usuario) {
		return new User(usuario.getUsuario(), usuario.getClave(), buildGrantedAuthorities(usuario.getRol()));
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(UsuarioRol rol) {
		return Arrays.asList(new SimpleGrantedAuthority(rol.getRol()));
	}

	@Override
	public List<Usuario> traerUsuarios() {

		return usuarioRepository.findAll();
	}

	@Override
	public Usuario traerUsuario(long idUsuario) {

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
		
		if(usuarioOptional.isEmpty()) {
			throw new RuntimeException("El usuario con ID " + idUsuario + " no existe en la base de datos.");
		}
		return usuarioOptional.get();
	}
	
	
}
