package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.repositories.IArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;

import jakarta.transaction.Transactional;

public class ArticuloService implements IArticuloService {

	@Autowired
	private IArticuloRepository articuloRepository;
	
	@Override
	public List<Articulo> traerArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo traerArticulo(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Articulo crearArticulo(Articulo articulo) {
		Optional<Articulo> articuloOptional = articuloRepository.findById(articulo.getIdArticulo());
		
		if(articuloOptional.isPresent()) {
			throw new RuntimeException("El articulo ya existe en la base de datos");
		}
		
		return articuloRepository.save(articulo);
	}

	@Override
	@Transactional
	public void generarCompra(Usuario usuario, Articulo articulo, int cantidad) {
		// TODO Auto-generated method stub
	}
}
