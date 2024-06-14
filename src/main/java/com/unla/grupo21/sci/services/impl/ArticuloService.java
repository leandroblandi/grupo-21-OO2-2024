package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;
import com.unla.grupo21.sci.repositories.IArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;

import jakarta.transaction.Transactional;

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

		if (articuloOptional.isEmpty()) {
			throw new NoEncontradoException(id);
		}

		return articuloOptional.get();
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) {
		Optional<Articulo> articuloOptional = articuloRepository.findById(articulo.getIdArticulo());

		if (articuloOptional.isPresent()) {
			throw new YaExisteException(articuloOptional.get().getIdArticulo());
		}

		return articuloRepository.save(articulo);
	}

	@Transactional
	@Override
	public Articulo modificarArticulo(Articulo articulo) {
		traerArticulo(articulo.getIdArticulo());
		return articuloRepository.save(articulo);
	}

	@Override
	public Articulo borrarArticulo(Articulo articulo) {
		articulo.setActivo(false);
		return modificarArticulo(articulo);
	}

}
