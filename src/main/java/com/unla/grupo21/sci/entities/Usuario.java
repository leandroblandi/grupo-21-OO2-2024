package com.unla.grupo21.sci.entities;

import org.hibernate.validator.constraints.Length;

import com.unla.grupo21.sci.enums.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	@Column(nullable = false)
	private boolean activo;
}
