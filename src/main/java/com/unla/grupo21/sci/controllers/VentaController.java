package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.VentaDto;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;
import com.unla.grupo21.sci.services.IUsuarioService;
import com.unla.grupo21.sci.services.IVentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VentaController {

	@Autowired
	private IVentaService service;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/ventas")
	public ResponseEntity<List<Venta>> traerVentas() {
		List<Venta> ventas = service.traerVentas();
		return ResponseEntity.ok(ventas);
	}

	@GetMapping("/ventas/{id}")
	public ResponseEntity<Venta> traerVenta(@PathVariable Long id) {
		Venta venta = service.traerVenta(id);
		return ResponseEntity.ok(venta);
	}

	@PostMapping("/ventas")
	public ResponseEntity<Venta> generarVenta(@Valid @RequestBody VentaDto ventaDto) {
		Usuario usuario = usuarioService.traerUsuario(ventaDto.getIdUsuario());
		Venta venta = service.generarVenta(usuario, ventaDto.getItems());
		return ResponseEntity.ok(venta);
	}
	
	@GetMapping("/ventas/usuario/{idUsuario}")
	public ResponseEntity<List<Venta>> traerVentasPorUsuario(@PathVariable Long idUsuario){
		List<Venta> venta = service.traerVentasPorUsuario(idUsuario);
		return ResponseEntity.ok(venta);
	}

}
