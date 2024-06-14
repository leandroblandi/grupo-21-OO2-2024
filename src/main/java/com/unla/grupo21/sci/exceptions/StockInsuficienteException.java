package com.unla.grupo21.sci.exceptions;

/**
 * Se utiliza esta clase para aclarar cuando el stock es insuficiente para
 * actualizar el lote, cuando se realiza una venta
 */
public class StockInsuficienteException extends RuntimeException {
	private static final long serialVersionUID = -3013836960724715148L;

	public StockInsuficienteException(int cantidadDisponible) {
		super("No hay suficiente stock para realizar la compra. Stock disponible: " + cantidadDisponible);
	}
}
