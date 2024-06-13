package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.services.IArticuloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired
	private IArticuloService service;

	@GetMapping("/articulos")
	public ResponseEntity<List<Articulo>> traerArticulos() {
		List<Articulo> articulos = service.traerArticulos();
		return ResponseEntity.ok(articulos);
	}

	@GetMapping("/articulos/{id}")
	public ResponseEntity<Articulo> traerArticulo(@PathVariable Long id) {
		Articulo articulo = service.traerArticulo(id);
		return ResponseEntity.ok(articulo);
	}

	@PostMapping("/articulos")
	public ResponseEntity<Articulo> crearArticulo(@Valid @RequestBody ArticuloDto articuloDto) {
		Articulo articulo = Articulo.builder().descripcion(articuloDto.getDescripcion()).costo(articuloDto.getCosto())
				.precioVenta(articuloDto.getPrecioVenta()).activo(true).build();

		return ResponseEntity.ok(service.crearArticulo(articulo));
	}

	public ResponseEntity<Articulo> borrarArticulo(@PathVariable Long id) {

		Articulo articulo = service.traerArticulo(id);

		return ResponseEntity.ok(service.borrarArticulo(articulo));
	}

	@PutMapping("/articulos/{id}")
	public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Long id,
			@Valid @RequestBody ArticuloDto articuloDto) {
		Articulo articulo = service.traerArticulo(id);
		articulo.setCosto(articuloDto.getCosto());
		articulo.setDescripcion(articuloDto.getDescripcion());
		articulo.setPrecioVenta(articuloDto.getPrecioVenta());

		return ResponseEntity.ok(service.modificarArticulo(articulo));
	}

}
