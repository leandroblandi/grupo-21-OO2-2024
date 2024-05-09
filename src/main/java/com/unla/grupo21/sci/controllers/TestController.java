package com.unla.grupo21.sci.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TestController {
	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		return ResponseEntity.ok("sci works!");
	}
}
