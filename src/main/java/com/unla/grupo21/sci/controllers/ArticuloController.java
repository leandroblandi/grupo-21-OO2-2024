package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.services.IArticuloService;

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
}
