package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.Usuario;

public interface IArticuloService {
	public List<Articulo> traerArticulos();
	
	public Articulo traerArticulo(long id);
	
	public Articulo crearArticulo(Articulo articulo);
	
	public void generarCompra(Usuario usuario, Articulo articulo, int cantidad);
}
