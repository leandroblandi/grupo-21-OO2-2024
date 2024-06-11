package com.unla.grupo21.sci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.entities.ItemVenta;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;
import com.unla.grupo21.sci.repositories.IVentaRepository;
import com.unla.grupo21.sci.services.IVentaService;

@Service
public class VentaService implements IVentaService{

	@Autowired
	private IVentaRepository ventaRepository;
	
	@Override
	public List<Venta> traerVentas() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta traerVenta(Long id) {
		Optional<Venta> ventaOptional = ventaRepository.findById(id);
		
		if(ventaOptional.isEmpty()) {
			throw new RuntimeException("La venta con ID " + id + " no existe en la base de datos.");
		}
		
		return ventaOptional.get();
	}

	@Override
	public Venta generarVenta(Usuario usuario, List<ItemVenta> items) {
		// TODO Auto-generated method stub
		return null;
	}

}
