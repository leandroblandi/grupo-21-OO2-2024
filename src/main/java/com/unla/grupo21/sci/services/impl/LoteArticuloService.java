package com.unla.grupo21.sci.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;
import com.unla.grupo21.sci.repositories.ILoteArticuloRepository;
import com.unla.grupo21.sci.services.ILoteArticuloService;

@Service
public class LoteArticuloService implements ILoteArticuloService {
	@Autowired
	private ILoteArticuloRepository loteArticuloRepository;

	@Override
	public List<LoteArticulo> traerLotes() {
		return loteArticuloRepository.findAll();
	}

	@Override
	public LoteArticulo traerLote(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoteArticulo generarAltaLote(Articulo articulo, int cantidad, String proveedor, double precio) {
		// TODO Auto-generated method stub
		return null;
	}
}