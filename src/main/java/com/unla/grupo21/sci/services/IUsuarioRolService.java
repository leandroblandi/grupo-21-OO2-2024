package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.UsuarioRol;

public interface IUsuarioRolService {

	public List<UsuarioRol> traerUsuarioRol();

	public UsuarioRol traerUsuarioRol(int id);

	public UsuarioRol traerUsuarioRol(String nombre);

	public UsuarioRol crearUsuarioRol(String nombre);

}
