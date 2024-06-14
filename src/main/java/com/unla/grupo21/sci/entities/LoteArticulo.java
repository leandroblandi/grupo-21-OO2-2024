package com.unla.grupo21.sci.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lote_articulos")
public class LoteArticulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLote;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "articulo_id", unique = true)
	private Articulo articulo;

	@Column(nullable = false)
	@Min(0)
	private int cantidad;

	@Column(nullable = false)
	private double precioCompra;

	@Column(nullable = true)
	private String proveedor;

	@Column(nullable = false)
	private LocalDateTime fechaRecepcion;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;

}
