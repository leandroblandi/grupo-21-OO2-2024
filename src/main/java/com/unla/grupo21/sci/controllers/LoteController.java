package com.unla.grupo21.sci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo21.sci.services.ILoteArticuloService;

@Controller
@RequestMapping("/lotes")
public class LoteController {
	@Autowired
	private ILoteArticuloService service;
}
