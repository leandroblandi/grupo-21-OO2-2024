package com.unla.grupo21.sci.services;

import java.util.List;

import com.unla.grupo21.sci.dtos.ArticuloCantidadDto;
import com.unla.grupo21.sci.dtos.ItemVentaDto;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;

public interface IVentaService {

	/**
	 * Trae todas las ventas realizadas de la base de datos
	 * 
	 * @return Una lista de todas las ventas realizadas
	 */
	public List<Venta> traerVentas();

	/**
	 * Trae una venta de la base de datos tomando el id proporcionado
	 * 
	 * @param id El id del venta
	 * @return Un venta con el id buscado
	 * @throws NoEncontradoException Si el venta no existe
	 */
	public Venta traerVenta(Long id);

	/**
	 * Realiza una venta, de los items al usuario proporcionado, generando una
	 * disminucion en el lote del articulo que compra
	 * 
	 * @param usuario  El usuario al que se le realiza la venta
	 * @param itemsDto Los items con los IDs de los articulos, cantidades y
	 *                 subtotales
	 * @return Un objeto Venta con los datos
	 */
	public Venta generarVenta(Usuario usuario, List<ItemVentaDto> itemsDto);

	public List<ArticuloCantidadDto> traerArticulosMasVendidos();

	public List<Venta> traerVentasPorUsuario(String usuario);

	public int traerTotalVentas();
}
