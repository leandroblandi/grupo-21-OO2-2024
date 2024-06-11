package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.ItemVenta;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;

public interface IVentaService {
	
	public List<Venta> traerVentas();
	
	public Venta traerVenta(Long id);
	
	public Venta generarVenta(Usuario usuario, List<ItemVenta> items);
}
