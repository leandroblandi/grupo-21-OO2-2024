package com.unla.grupo21.sci.exceptions;

/**
 * Se utiliza esta clase para aclarar cuando una entidad ya existe en la base de
 * datos
 */
public class YaExisteException extends RuntimeException {
	private static final long serialVersionUID = -2105879702918560904L;

	public YaExisteException(Long id) {
		super("El recurso con id " + id + " ya existe");
	}
	
	public YaExisteException(String nombre) {
		super("El recurso con nombre " + nombre + " ya existe");
	}
}
