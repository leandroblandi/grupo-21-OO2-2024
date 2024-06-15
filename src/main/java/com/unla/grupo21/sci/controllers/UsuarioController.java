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

import com.unla.grupo21.sci.dtos.UsuarioDto;
import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.services.IUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> traerUsuarios() {
		List<Usuario> usuarios = usuarioService.traerUsuarios();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> traerUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.traerUsuario(id);
		return ResponseEntity.ok(usuario);
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> registrarCliente(@Valid @RequestBody UsuarioDto dto) {
		Usuario usuario = usuarioService.registrarUsuario(dto, false);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/usuarios/admin")
	public ResponseEntity<Usuario> registrarAdministrador(@Valid @RequestBody UsuarioDto dto) {
		Usuario usuario = usuarioService.registrarUsuario(dto, true);
		return ResponseEntity.ok(usuario);
	}
}
