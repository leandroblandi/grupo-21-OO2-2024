package com.unla.grupo21.sci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.services.IUsuarioService;

@RestController
@RequestMapping("/api")
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

}
