package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.ArticuloCantidadDto;
import com.unla.grupo21.sci.services.IVentaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InformeController {

	@Autowired
	private IVentaService service;
	
	@GetMapping("/informes/articulos/top")
	public ResponseEntity<List<ArticuloCantidadDto>> traerArticulosMasVendidos(){
		List<ArticuloCantidadDto> list= service.traerArticulosMasVendidos();
		return ResponseEntity.ok(list);
	}
	

}
