package com.unla.grupo21.sci.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@Column(nullable = false, unique = true)
	@Length(min = 4, max = 64)
	private String usuario;

	@Column(nullable = false)
	@Length(min = 4, max = 256)
	private String clave;

	@Column(nullable = false)
	@Length(min = 4, max = 128)
	private String nombre;

	@Column(nullable = false)
	@Length(min = 4, max = 128)
	private String apellido;

	@Column(nullable = false, unique = true)
	@Min(0)
	private int dni;

	@OneToOne(fetch=FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@JsonManagedReference
	private UsuarioRol rol;
	
	@Column(nullable = false)
	private boolean activo;
	
	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;
	
	public String getApellido() {
		return apellido;
	}
}
