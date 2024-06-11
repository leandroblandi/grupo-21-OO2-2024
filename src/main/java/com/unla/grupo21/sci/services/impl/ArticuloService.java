package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.repositories.IArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;

@Service
public class ArticuloService implements IArticuloService {

	@Autowired
	private IArticuloRepository articuloRepository;

	@Override
	public List<Articulo> traerArticulos() {
		return articuloRepository.findAll();
	}

	@Override
	public Articulo traerArticulo(long id) {
		
		Optional<Articulo> articuloOptional = articuloRepository.findById(id);
		
		if(articuloOptional.isEmpty()) {
			throw new RuntimeException("El articulo con ID " + id + " no existe en la base de datos.");
		}
		
		return articuloOptional.get();
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) {
		Optional<Articulo> articuloOptional = articuloRepository.findById(articulo.getIdArticulo());

		if (articuloOptional.isPresent()) {
			throw new RuntimeException("El articulo ya existe en la base de datos");
		}

		return articuloRepository.save(articulo);
	}
}
