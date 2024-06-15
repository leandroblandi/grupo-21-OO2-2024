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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.converters.impl.UsuarioConverter;
import com.unla.grupo21.sci.dtos.UsuarioDto;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.UsuarioRol;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;
import com.unla.grupo21.sci.repositories.IUsuarioRepository;
import com.unla.grupo21.sci.services.IUsuarioRolService;
import com.unla.grupo21.sci.services.IUsuarioService;

/**
 * Este service implementa una interfaz de Spring para poder autenticar. Debe
 * utilizar un repository para buscar los usuarios que estén registrados
 */
@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private IUsuarioRolService rolService;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(username);
		if (usuarioOptional.isEmpty()) {
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

		if (usuarioOptional.isEmpty()) {
			throw new NoEncontradoException(idUsuario);
		}
		return usuarioOptional.get();
	}

	@Override
	public Usuario registrarUsuario(UsuarioDto usuarioDto, boolean administrador) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(usuarioDto.getUsuario());

		// El nombre de usuario es unico, por lo que se comprueba por nombre de usuario
		if (usuarioOptional.isPresent()) {
			throw new YaExisteException(usuarioDto.getUsuario());
		}

		Usuario usuario = usuarioConverter.convert(usuarioDto);

		// Ciframos la clave con BCrypt y se la reasignamos a la clave del usuario
		// que estaba en crudo
		String claveCifrada = passwordEncoder.encode(usuario.getClave());
		usuario.setClave(claveCifrada);

		// Seteamos roles
		setearRoles(usuario, administrador);

		return usuarioRepository.save(usuario);
	}

	private void setearRoles(Usuario usuario, boolean administrador) {
		UsuarioRol rol = rolService.traerUsuarioRol("ROLE_CLIENTE");

		if (administrador) {
			rol = rolService.traerUsuarioRol("ROLE_ADMINISTRADOR");
		}

		usuario.setRol(rol);
	}
}
