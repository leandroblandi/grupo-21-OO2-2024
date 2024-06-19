package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.ArticuloCantidadDto;
import com.unla.grupo21.sci.dtos.ArticuloDiasDto;
import com.unla.grupo21.sci.services.IArticuloService;
import com.unla.grupo21.sci.services.IUsuarioService;
import com.unla.grupo21.sci.services.IVentaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InformeController {

	@Autowired
	private IVentaService ventaService;

	@Autowired
	private IArticuloService articuloService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/informes/articulos/top")
	public ResponseEntity<List<ArticuloCantidadDto>> traerArticulosMasVendidos() {
		List<ArticuloCantidadDto> list = ventaService.traerArticulosMasVendidos();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/informes/ventas/total")
	public ResponseEntity<Integer> traerTotalVentas() {
		int total = ventaService.traerTotalVentas();
		return ResponseEntity.ok(total);
	}

	@GetMapping("/informes/articulos/tiempo/{dias}")
	public ResponseEntity<List<ArticuloDiasDto>> traerArticulosConMasDias(@PathVariable int dias) {
		List<ArticuloDiasDto> list = articuloService.traerArticulosConMasDias(dias);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/informes/clientes/registrados")
	public ResponseEntity<Integer> traerTotalClientes() {
		int total = usuarioService.traerTotalClientes();
		return ResponseEntity.ok(total);
	}

	@GetMapping("/informes/administradores/registrados")
	public ResponseEntity<Integer> traerTotalAdmins() {
		int total = usuarioService.traerTotalAdmins();
		return ResponseEntity.ok(total);
	}

}
