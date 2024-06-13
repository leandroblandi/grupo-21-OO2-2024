package com.unla.grupo21.sci.dtos;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloDto {

	@Length(min = 4, max = 128)
	private String descripcion;

	private double costo;

	private double precioVenta;

}
