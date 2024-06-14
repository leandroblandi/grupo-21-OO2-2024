package com.unla.grupo21.sci.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaDto {
	private LocalDate fecha;

	private List<ItemVentaDto> items;

	private Long idUsuario;
}
