package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Articulo;

public interface IArticuloService {
	public List<Articulo> traerArticulos();
	
	public Articulo traerArticulo(long id);
	
	public Articulo crearArticulo(Articulo articulo);
	
	public Articulo modificarArticulo(Articulo articulo);
}
