package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.converters.impl.ArticuloConverter;
import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.services.IArticuloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ArticuloController {

	@Autowired
	private IArticuloService service;

	@Autowired
	private ArticuloConverter articuloConverter;

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
		Articulo articulo = articuloConverter.convert(articuloDto);
		Articulo articuloDb = service.crearArticulo(articulo);
		return ResponseEntity.ok(articuloDb);
	}
	
	@DeleteMapping("/articulos/{id}")
	public ResponseEntity<Articulo> borrarArticulo(@PathVariable Long id) {
		Articulo articulo = service.traerArticulo(id);
		return ResponseEntity.ok(service.borrarArticulo(articulo));
	}

	@PutMapping("/articulos/{id}")
	public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Long id,
			@Valid @RequestBody ArticuloDto articuloDto) {
		return ResponseEntity.ok(service.modificarArticulo(id, articuloDto));
	}

}
