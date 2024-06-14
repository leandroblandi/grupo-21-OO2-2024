package com.unla.grupo21.sci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.LoginDto;
import com.unla.grupo21.sci.dtos.TokenResponseDto;
import com.unla.grupo21.sci.services.ILoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	private ILoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<TokenResponseDto> login(@Valid @RequestBody LoginDto loginDto) {
		TokenResponseDto token = loginService.login(loginDto.getUsuario(), loginDto.getClave());
		return ResponseEntity.ok(token);
	}
}
