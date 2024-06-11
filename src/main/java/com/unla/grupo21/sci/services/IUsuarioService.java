package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> traerUsuarios();
	
	public Usuario traerUsuario(long idUsuario);
	
}
