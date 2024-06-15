package com.unla.grupo21.sci.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.dtos.ItemVentaDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.ItemVenta;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.repositories.IVentaRepository;
import com.unla.grupo21.sci.services.IArticuloService;
import com.unla.grupo21.sci.services.ILoteArticuloService;
import com.unla.grupo21.sci.services.IUsuarioService;
import com.unla.grupo21.sci.services.IVentaService;

import jakarta.transaction.Transactional;

@Service
public class VentaService implements IVentaService {
	@Autowired
	private IVentaRepository ventaRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IArticuloService articuloService;

	@Autowired
	private ILoteArticuloService loteService;

	@Override
	public List<Venta> traerVentas() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta traerVenta(Long id) {
		Optional<Venta> ventaOptional = ventaRepository.findById(id);

		if (ventaOptional.isEmpty()) {
			throw new NoEncontradoException(id);
		}

		return ventaOptional.get();
	}

	@Override
	@Transactional
	public Venta generarVenta(Usuario usuario, List<ItemVentaDto> itemsDto) {
		Usuario usuarioVenta = usuarioService.traerUsuario(usuario.getIdUsuario());
		List<ItemVenta> listaItems = convertirItems(itemsDto);
		double precioFinal = calcularPrecioFinal(listaItems);

		Venta venta = Venta.builder().fechaVenta(LocalDate.now()).items(listaItems).precioFinal(precioFinal)
				.usuario(usuarioVenta).build();
		restarCantidadesEnLote(listaItems);
		return ventaRepository.save(venta);
	}

	/**
	 * Convierte un DTO de ItemVenta a la entidad ItemVenta
	 * 
	 * @param itemVentaDto El objeto DTO ItemVentaDto
	 * @return Un objeto ItemVenta
	 */
	private ItemVenta convertirItem(ItemVentaDto itemVentaDto) {
		Articulo articulo = articuloService.traerArticulo(itemVentaDto.getIdArticulo());
		double total = articulo.getPrecioVenta() * itemVentaDto.getCantidad();
		return ItemVenta.builder().articulo(articulo).cantidad(itemVentaDto.getCantidad()).subtotal(total).build();
	}

	/**
	 * Convierte una lista de ItemVentaDto
	 * 
	 * @param itemsVentaDto La lista de objetos ItemVentaDto
	 * @return Una lista de entidades ItemVenta
	 */
	private List<ItemVenta> convertirItems(List<ItemVentaDto> itemsVentaDto) {
		List<ItemVenta> items = new ArrayList<ItemVenta>();
		for (ItemVentaDto itemDto : itemsVentaDto) {
			items.add(convertirItem(itemDto));
		}
		return items;
	}

	/**
	 * Recorre las entidades ItemVenta, y realiza la suma total de
	 * los subtotales
	 * 
	 * @param itemsVenta La lista de objetos ItemVenta
	 * @return El precio total de todos los items de la venta
	 */
	private double calcularPrecioFinal(List<ItemVenta> itemsVenta) {
		double total = 0;
		for (ItemVenta itemVenta : itemsVenta) {
			total += itemVenta.getSubtotal();
		}
		return total;
	}

	/**
	 * Metodo auxiliar para recorrer cada item, y restarle la cantidad
	 * al lote correspondiente en el sistema.
	 * 
	 * @param items La lista de objetos ItemVenta
	 */
	private void restarCantidadesEnLote(List<ItemVenta> items) {
		for (ItemVenta item : items) {
			loteService.actualizarCantidadEnLote(item.getArticulo(), item.getCantidad());
		}
	}
}
