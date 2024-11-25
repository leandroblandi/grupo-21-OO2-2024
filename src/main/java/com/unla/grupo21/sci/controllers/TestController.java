package com.unla.grupo21.sci.controllers;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo21.sci.dtos.ErrorDetailsDto;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TestController {
	@GetMapping("/status")
	public ResponseEntity<ErrorDetailsDto> getStatus() {
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now())
				.details("La API está funcionando correctamente").build();
		return ResponseEntity.ok(dto);
	}
}
