package com.unla.grupo21.sci.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;
import com.unla.grupo21.sci.repositories.ILoteArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;
import com.unla.grupo21.sci.services.ILoteArticuloService;

import jakarta.transaction.Transactional;

@Service
public class LoteArticuloService implements ILoteArticuloService {
	@Autowired
	private ILoteArticuloRepository loteArticuloRepository;
	@Autowired
	private IArticuloService articuloService;

	@Override
	public List<LoteArticulo> traerLotes() {
		return loteArticuloRepository.findAll();
	}

	@Override
	public LoteArticulo traerLote(long id) {
		Optional<LoteArticulo> loteOptional = loteArticuloRepository.findById(id);

		if (loteOptional.isEmpty()) {
			throw new RuntimeException("El lote con ID " + id + " no existe en la base de datos.");
		}
		return loteOptional.get();
	}

	@Override
	@Transactional
	public LoteArticulo generarAltaLote(Articulo articulo, int cantidad, String proveedor) {
		Articulo articuloDB = articuloService.traerArticulo(articulo.getIdArticulo());
		double precioFinal = articulo.getCosto() * (double) cantidad;
		LoteArticulo loteArticulo = LoteArticulo.builder().articulo(articuloDB).cantidad(cantidad)
				.precioCompra(precioFinal).proveedor(proveedor).fechaRecepcion(LocalDateTime.now()).build();
		return loteArticuloRepository.save(loteArticulo);
	}
}
