package com.unla.grupo21.sci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
	private String usuario;
	private String clave;
}
