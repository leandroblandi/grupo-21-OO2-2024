package com.unla.grupo21.sci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo21.sci.services.IArticuloService;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
	@Autowired
	private IArticuloService service;
}
