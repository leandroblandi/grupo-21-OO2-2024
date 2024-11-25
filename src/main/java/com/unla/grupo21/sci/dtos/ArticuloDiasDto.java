package com.unla.grupo21.sci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticuloDiasDto {
	private String nombreArticulo;
	private long dias;
}
