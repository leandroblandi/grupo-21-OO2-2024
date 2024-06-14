package com.unla.grupo21.sci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private int dni;
}
