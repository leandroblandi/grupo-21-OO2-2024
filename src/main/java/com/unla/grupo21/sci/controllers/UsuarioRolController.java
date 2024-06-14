package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.entities.UsuarioRol;
import com.unla.grupo21.sci.services.IUsuarioRolService;
import com.unla.grupo21.sci.services.IUsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioRolController {
	
	@Autowired
	private IUsuarioRolService service;
	
	@GetMapping("/roles")
	public ResponseEntity<List<UsuarioRol>> traerRoles(){
		List<UsuarioRol> rolesUsuario = service.traerUsuarioRol();
		return ResponseEntity.ok(rolesUsuario);
	}
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<UsuarioRol> traerUsuarioRol(@PathVariable Integer id){
		UsuarioRol rol = service.traerUsuarioRol(id);
		return ResponseEntity.ok(rol);
	}
	
	@GetMapping("/roles/{nombre}")
	public ResponseEntity<UsuarioRol> traerUsuarioRol(@PathVariable String nombre){
		UsuarioRol rol = service.traerUsuarioRol(nombre);
		return ResponseEntity.ok(rol);
	}
	
	@PostMapping("/roles")
	public ResponseEntity<UsuarioRol> crearUsuarioRol(@RequestParam String nombre){
		UsuarioRol rol = service.crearUsuarioRol(nombre);
		return ResponseEntity.ok(rol);
	}
	
}
