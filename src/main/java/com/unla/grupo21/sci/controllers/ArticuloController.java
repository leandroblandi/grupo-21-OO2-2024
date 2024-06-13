package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.CrearArticuloDto;
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
	public ResponseEntity<Articulo> crearArticulo(@Valid @RequestBody CrearArticuloDto articuloDto){
		Articulo articulo = Articulo.builder().descripcion(articuloDto.getDescripcion()).costo(articuloDto.getCosto())
				.precioVenta(articuloDto.getPrecioVenta()).build();
		
		return ResponseEntity.ok(service.crearArticulo(articulo));
	}
}
