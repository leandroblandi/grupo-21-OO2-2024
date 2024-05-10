package com.unla.grupo21.sci.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lote_articulos")
public class LoteArticulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLote;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Articulo articulo;

	@Column(nullable = false)
	private int cantidad;

	@Column(nullable = false)
	private double precioCompra;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "lotes_proveedores", joinColumns = { @JoinColumn(name = "id_lote") }, inverseJoinColumns = {
			@JoinColumn(name = "id_proveedor") })
	private Proveedor proveedor;

}
