package com.unla.grupo21.sci.exceptions;

public class YaExisteException extends RuntimeException {
	private static final long serialVersionUID = -2105879702918560904L;

	public YaExisteException(Long id) {
		super("El recurso con id " + id + " ya existe");
	}
}
