package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Venta;

public interface IVentaService {
	
	public List<Venta> traerVentas();
	
	public Venta traerVenta(Long id);
}
