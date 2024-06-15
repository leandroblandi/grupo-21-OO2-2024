package com.unla.grupo21.sci.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.StockInsuficienteException;
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
			throw new NoEncontradoException(id);
		}
		return loteOptional.get();
	}

	@Override
	@Transactional
	public LoteArticulo generarAltaLote(long idArticulo, int cantidad, String proveedor, double costo) {
		Articulo articuloDB = articuloService.traerArticulo(idArticulo);
		double precioFinal = costo * cantidad;
		LoteArticulo loteArticulo = LoteArticulo.builder().articulo(articuloDB).cantidad(cantidad)
				.precioCompra(precioFinal).proveedor(proveedor).fechaRecepcion(LocalDateTime.now()).build();
		return loteArticuloRepository.save(loteArticulo);
	}

	@Override
	public void actualizarCantidadEnLote(Articulo articulo, int cantidadRequerida) {

		Optional<LoteArticulo> loteOptional = loteArticuloRepository.findByArticulo(articulo);

		if (loteOptional.isEmpty()) {
			throw new NoEncontradoException(articulo.getDescripcion());
		}

		LoteArticulo lote = loteOptional.get();

		if (lote.getCantidad() < cantidadRequerida) {
			throw new StockInsuficienteException(lote.getCantidad());
		}

		lote.setCantidad(lote.getCantidad() - cantidadRequerida);
		loteArticuloRepository.save(lote);
	}

	@Override
	public LoteArticulo aprovisionarLote(Articulo articulo, int cantidadRequerida) {
		Optional<LoteArticulo> loteOptional = loteArticuloRepository.findByArticulo(articulo);

		if (loteOptional.isEmpty()) {
			throw new NoEncontradoException(articulo.getDescripcion());
		}
		
		LoteArticulo lote = loteOptional.get();
		lote.setCantidad(lote.getCantidad() + cantidadRequerida);
		
		return loteArticuloRepository.save(lote);
	}
}
