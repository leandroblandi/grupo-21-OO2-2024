package com.unla.grupo21.sci.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unla.grupo21.sci.dtos.ErrorDetailsDto;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.StockInsuficienteException;
import com.unla.grupo21.sci.exceptions.YaExisteException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	public ResponseEntity<ErrorDetailsDto> handleException(AuthenticationCredentialsNotFoundException e) {
		log.error(e.getMessage());
		String mensaje = "Error al autenticar: datos incorrectos";
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now()).details(mensaje).build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ErrorDetailsDto> handleException(AuthenticationException e) {
		log.error(e.getMessage());
		String mensaje = "Error al autenticar: error inesperado";
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now()).details(mensaje).build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
	}

	@ExceptionHandler(NoEncontradoException.class)
	public ResponseEntity<ErrorDetailsDto> handleException(NoEncontradoException e) {
		log.error(e.getMessage());
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now()).details(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}

	@ExceptionHandler(YaExisteException.class)
	public ResponseEntity<ErrorDetailsDto> handleException(YaExisteException e) {
		log.error(e.getMessage());
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now()).details(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}

	@ExceptionHandler(StockInsuficienteException.class)
	public ResponseEntity<ErrorDetailsDto> handleException(StockInsuficienteException e) {
		log.error(e.getMessage());
		ErrorDetailsDto dto = ErrorDetailsDto.builder().date(LocalDateTime.now()).details(e.getMessage()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}

}
