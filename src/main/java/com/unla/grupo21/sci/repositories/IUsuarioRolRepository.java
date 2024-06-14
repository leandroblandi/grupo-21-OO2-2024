package com.unla.grupo21.sci.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo21.sci.entities.UsuarioRol;

public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {
	public Optional<UsuarioRol> findByRol(String rol);
	
}
