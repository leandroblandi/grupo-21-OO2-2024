package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.UsuarioRol;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;
import com.unla.grupo21.sci.repositories.IUsuarioRolRepository;
import com.unla.grupo21.sci.services.IUsuarioRolService;

@Service
public class UsuarioRolService implements IUsuarioRolService {
	@Autowired
	private IUsuarioRolRepository usuarioRolRepository;

	@Override
	public List<UsuarioRol> traerUsuarioRol() {
		return usuarioRolRepository.findAll();
	}

	@Override
	public UsuarioRol traerUsuarioRol(int id) {
		Optional<UsuarioRol> usuarioRolOptional = usuarioRolRepository.findById(id);
		if (usuarioRolOptional.isEmpty()) {
			throw new NoEncontradoException((long) id);
		}
		return usuarioRolOptional.get();
	}
	
	@Override
	public UsuarioRol traerUsuarioRol(String nombre) {
		Optional<UsuarioRol> usuarioRolOptional = usuarioRolRepository.findByRol(nombre);
		if (usuarioRolOptional.isEmpty()) {
			throw new NoEncontradoException(nombre);
		}
		return usuarioRolOptional.get();
	}

	@Override
	public UsuarioRol crearUsuarioRol(String nombre) {
		Optional<UsuarioRol> usuarioRolOptional = usuarioRolRepository.findByRol(nombre);

		if (usuarioRolOptional.isPresent()) {
			throw new YaExisteException(nombre);
		}

		UsuarioRol usuarioRol = UsuarioRol.builder().rol(nombre).build();
		return usuarioRolRepository.save(usuarioRol);
	}
}
