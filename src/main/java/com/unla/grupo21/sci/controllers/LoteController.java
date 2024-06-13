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

import com.unla.grupo21.sci.dtos.CrearLoteDto;
import com.unla.grupo21.sci.entities.LoteArticulo;
import com.unla.grupo21.sci.services.ILoteArticuloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoteController {
	@Autowired
	private ILoteArticuloService service;

	@GetMapping("/lotes")
	public ResponseEntity<List<LoteArticulo>> traerLotes() {
		List<LoteArticulo> lotes = service.traerLotes();
		return ResponseEntity.ok(lotes);
	}

	@GetMapping("/lotes/{id}")
	public ResponseEntity<LoteArticulo> traerLote(@PathVariable Long id) {
		LoteArticulo lote = service.traerLote(id);
		return ResponseEntity.ok(lote);
	}

	@PostMapping("/lotes")
	public ResponseEntity<LoteArticulo> crearLote(@Valid @RequestBody CrearLoteDto loteDto) {
		return ResponseEntity.ok(service.generarAltaLote(loteDto.getIdArticulo(), loteDto.getCantidad(),
				loteDto.getProveedor(), loteDto.getCosto()));
	}
}
