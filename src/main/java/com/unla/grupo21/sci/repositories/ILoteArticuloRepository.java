package com.unla.grupo21.sci.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.entities.LoteArticulo;

@Repository
public interface ILoteArticuloRepository extends JpaRepository<LoteArticulo, Long> {
	public Optional<LoteArticulo> findByArticulo(Articulo articulo);
}
