package com.unla.grupo21.sci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.services.ILoteArticuloService;

@RestController
@RequestMapping("/api")
public class LoteController {
	@Autowired
	private ILoteArticuloService service;
}
