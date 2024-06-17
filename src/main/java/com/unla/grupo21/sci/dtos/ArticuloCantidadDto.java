package com.unla.grupo21.sci.dtos;

import com.unla.grupo21.sci.entities.Articulo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloCantidadDto {
	private Articulo articulo;
	
	private Long cantidad;
}
