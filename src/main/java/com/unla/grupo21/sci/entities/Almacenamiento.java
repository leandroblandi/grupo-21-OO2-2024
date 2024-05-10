package com.unla.grupo21.sci.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "almacenamientos")
public class Almacenamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAlmacenamiento;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<LoteArticulo> lotes;

}
