package com.unla.grupo21.sci.converters.impl;

import org.springframework.stereotype.Component;

import com.unla.grupo21.sci.converters.Converter;
import com.unla.grupo21.sci.dtos.UsuarioDto;
import com.unla.grupo21.sci.entities.Usuario;

@Component
public class UsuarioConverter extends Converter<Usuario, UsuarioDto> {
	@Override
	protected Usuario convertModel(UsuarioDto model) {
		return Usuario.builder().usuario(model.getUsuario()).clave(model.getClave()).nombre(model.getNombre())
				.apellido(model.getApellido()).dni(model.getDni()).activo(true).build();
	}

	@Override
	protected UsuarioDto unconvertModel(Usuario model) {
		return UsuarioDto.builder().usuario(model.getUsuario()).clave(model.getClave()).nombre(model.getNombre())
				.apellido(model.getApellido()).dni(model.getDni()).build();
	}
}
