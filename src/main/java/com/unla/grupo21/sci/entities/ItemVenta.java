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
@Table(name = "items_venta")
public class ItemVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idItem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
	private Articulo articulo;

	@Column(nullable = false)
	@Min(1)
	private int cantidad;

	@Column(nullable = false)
	private double subtotal;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;
}
