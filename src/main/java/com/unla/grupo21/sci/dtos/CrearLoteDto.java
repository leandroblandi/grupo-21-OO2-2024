package com.unla.grupo21.sci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrearLoteDto {

	private long idArticulo;

	private int cantidad;

	private double precioCompra;

	private String proveedor;

	private double costo;

}
