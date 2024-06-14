package com.unla.grupo21.sci.exceptions;

/**
 * Se utiliza esta clase para aclarar cuando una entidad no es encontrada en la
 * base de datos
 */
public class NoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = -7351212460634729652L;

	public NoEncontradoException(Long id) {
		super("El recurso con id " + id + " no se ha encontrado");
	}

	public NoEncontradoException(String nombre) {
		super("El recurso con nombre " + nombre + " no se ha encontrado");
	}
}
