package com.unla.grupo21.sci.exceptions;

public class NoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = -7351212460634729652L;

	public NoEncontradoException(Long id) {
		super("El recurso con id " + id + " no se ha encontrado");
	}
	
	public NoEncontradoException(String nombre) {
		super("El recurso con nombre " + nombre + " no se ha encontrado");
	}
}
