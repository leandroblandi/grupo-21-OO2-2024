package com.unla.grupo21.sci.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "articulos")
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArticulo;

	@Column(nullable = false)
	@Length(min = 4, max = 128)
	private String descripcion;

	@Column(nullable = false)
	private double costo;

	@Column(nullable = false)
	private double precioVenta;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;

	@Column(nullable = false)
	private boolean activo;
	
	@Column(nullable = false)
	private boolean estaEnUnLote;
}
