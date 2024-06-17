package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;
import com.unla.grupo21.sci.repositories.IArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;
import com.unla.grupo21.sci.services.ILoteArticuloService;

import jakarta.transaction.Transactional;

@Service
public class ArticuloService implements IArticuloService {
	private static int CANTIDAD_DEFECTO_LOTE = 50;
	
	@Autowired
	private IArticuloRepository articuloRepository;

	@Autowired
	@Lazy
	private ILoteArticuloService loteService;

	@Override
	public List<Articulo> traerArticulos() {
		return articuloRepository.findAll();
	}

	@Override
	public Articulo traerArticulo(long id) {

		Optional<Articulo> articuloOptional = articuloRepository.findById(id);

		if (articuloOptional.isEmpty()) {
			throw new NoEncontradoException(id);
		}

		return articuloOptional.get();
	}

	@Override
	@Transactional
	public Articulo crearArticulo(Articulo articulo) {
		Optional<Articulo> articuloOptional = articuloRepository.findById(articulo.getIdArticulo());

		if (articuloOptional.isPresent()) {
			throw new YaExisteException(articuloOptional.get().getIdArticulo());
		}

		Articulo articuloDb = articuloRepository.save(articulo);
		loteService.generarAltaLote(articuloDb.getIdArticulo(), CANTIDAD_DEFECTO_LOTE, "Default supplier SA", articuloDb.getCosto());

		return articuloDb;
	}

	@Transactional
	@Override
	public Articulo modificarArticulo(long id, ArticuloDto articuloDto) {
		Articulo articulo = traerArticulo(id);

		articulo.setCosto(articuloDto.getCosto());
		articulo.setDescripcion(articuloDto.getDescripcion());
		articulo.setPrecioVenta(articuloDto.getPrecioVenta());

		return articuloRepository.save(articulo);
	}

	@Override
	public Articulo borrarArticulo(Articulo articulo) {
		traerArticulo(articulo.getIdArticulo());
		articulo.setActivo(false);
		return articuloRepository.save(articulo);
	}

}
