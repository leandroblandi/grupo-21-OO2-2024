package com.unla.grupo21.sci.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProveedor;
	
	@Column(nullable = false)
	private String razonSocial;
	
	@Column(nullable = false, unique = true)
	private String cuit;
}
