package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;

public interface ILoteArticuloService {

	public List<LoteArticulo> traerLotes();

	public LoteArticulo traerLote(long id);

	public LoteArticulo generarAltaLote(long idArticulo, int cantidad, String proveedor, double costos);
}
