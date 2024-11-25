package com.unla.grupo21.sci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemVentaDto {

	private Long idArticulo;

	private int cantidad;
}
