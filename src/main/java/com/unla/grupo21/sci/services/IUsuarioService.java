package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;

public interface IUsuarioService {

	/**
	 * Trae todos los usuarios de la base de datos
	 * 
	 * @return Una lista de todos los usuarios cargados
	 */
	public List<Usuario> traerUsuarios();

	/**
	 * Trae un usuario de la base de datos tomando el id proporcionado
	 * 
	 * @param id El id del usuario
	 * @return Un usuario con el id buscado
	 * @throws NoEncontradoException Si el usuario no existe
	 */
	public Usuario traerUsuario(long idUsuario);

}
