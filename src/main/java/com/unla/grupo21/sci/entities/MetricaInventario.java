package com.unla.grupo21.sci.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "metrica_inventarios")
public class MetricaInventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMetrica;

	@Column(nullable = false)
	private LocalDateTime fecha;

	@Column(nullable = false)
	private double rotacionInventario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<MetricaArtMasVendido> metricaArticulosMasVendidos;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<MetricaArtTiempoAlmacenado> metricaTiempoArticulos;
}
