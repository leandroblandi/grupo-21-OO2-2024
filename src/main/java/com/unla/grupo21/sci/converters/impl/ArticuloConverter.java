package com.unla.grupo21.sci.converters.impl;

import org.springframework.stereotype.Component;

import com.unla.grupo21.sci.converters.Converter;
import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;

@Component
public class ArticuloConverter extends Converter<Articulo, ArticuloDto> {
	@Override
	protected Articulo convertModel(ArticuloDto model) {
		return Articulo.builder().descripcion(model.getDescripcion()).costo(model.getCosto())
				.precioVenta(model.getPrecioVenta()).activo(true).build();
	}

	@Override
	protected ArticuloDto unconvertModel(Articulo model) {
		return ArticuloDto.builder().descripcion(model.getDescripcion()).costo(model.getCosto())
				.precioVenta(model.getPrecioVenta()).build();
	}
}
