package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.dtos.ArticuloDiasDto;
import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;

public interface IArticuloService {

	/**
	 * Trae todos los articulos de la base de datos
	 * 
	 * @return Una lista de todos los articulos cargados
	 */
	public List<Articulo> traerArticulos();

	/**
	 * Trae un articulo de la base de datos tomando el id proporcionado
	 * 
	 * @param id El id del articulo
	 * @return Un articulo con el id buscado
	 * @throws NoEncontradoException Si el articulo no existe
	 */
	public Articulo traerArticulo(long id);

	/**
	 * Almacena un articulo en la base de datos
	 * 
	 * @param articulo
	 * @return El objeto del articulo con su ID
	 * @throws YaExisteException si el articulo ya existe en la base de datos
	 */
	public Articulo crearArticulo(Articulo articulo);

	/**
	 * 
	 * Modifica un articulo existente, setea sus atributos descripcion, costo y
	 * precio de venta
	 * 
	 * 
	 * @param id          El id del articulo existente a modificar
	 * @param articuloDto El objeto con los datos a modificar
	 * @return El articulo modificado
	 * @throws NoEncontradoException si el articulo no existe
	 */
	public Articulo modificarArticulo(long id, ArticuloDto articuloDto);

	/**
	 * Elimina un articulo de la base de datos, mediante eliminacion logica
	 * 
	 * @param articulo El articulo a eliminar
	 * @return El articulo eliminado, con activo seteado en false
	 * @throws NoEncontradoException si el articulo a eliminar no existe
	 */
	public Articulo borrarArticulo(Articulo articulo);
	
	public List<ArticuloDiasDto> traerArtculosConMasDias(int dias);
}
