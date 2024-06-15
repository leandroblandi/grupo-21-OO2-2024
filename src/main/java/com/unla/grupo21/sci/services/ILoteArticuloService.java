package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.StockInsuficienteException;

public interface ILoteArticuloService {

	/**
	 * Trae todos los lotes de la base de datos
	 * 
	 * @return Una lista de todos los lotes cargados
	 */
	public List<LoteArticulo> traerLotes();

	/**
	 * Trae un lote de la base de datos tomando el id proporcionado
	 * 
	 * @param id El id del lote
	 * @return Un lote con el id buscado
	 * @throws NoEncontradoException Si el lote no existe
	 */
	public LoteArticulo traerLote(long id);

	/**
	 * Da de alta un nuevo lote con un articulo especificado, una cantidad, un
	 * proveedor y los costos
	 * 
	 * @param idArticulo El id del articulo para almacenar el lote
	 * @param cantidad   La cantidad de articulos del mismo lote
	 * @param proveedor  El proveedor del lote
	 * @param costos     El costo del lote
	 * @return Un objeto lote generado junto con su ID
	 */
	public LoteArticulo generarAltaLote(long idArticulo, int cantidad, String proveedor, double costos);

	/**
	 * 
	 * Realiza una actualizacion de las cantidades de un lote con un articulo
	 * especifico
	 * 
	 * @param articulo          El articulo del lote
	 * @param cantidadRequerida La cantidad a restar
	 * @throws StockInsuficienteException Si la cantidad a restar es mayor a la que
	 *                                    hay en stock
	 */
	public void actualizarCantidadEnLote(Articulo articulo, int cantidadRequerida);

	/**
	 * 
	 * Realiza una actualizacion de las cantidades de un lote con un articulo
	 * especifico, aprovisiona un lote que corresponda con el articulo deseado
	 * 
	 * @param articulo          El articulo del lote
	 * @param cantidadRequerida La cantidad a aprovisionar
	 * @return El lote con la nueva cantidad
	 */
	public LoteArticulo aprovisionarLote(Articulo articulo, int cantidadRequerida);

	
	public boolean eliminarLote(Long id);
}
