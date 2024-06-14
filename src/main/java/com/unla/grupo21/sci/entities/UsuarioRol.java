package com.unla.grupo21.sci.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "roles")
public class UsuarioRol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	@JsonBackReference
	private Usuario usuario;

	@Column(name = "rol", nullable = false, length = 100)
	private String rol;

	@CreationTimestamp
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	private LocalDateTime fechaActualizacion;
}
