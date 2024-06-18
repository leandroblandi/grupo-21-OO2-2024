package com.unla.grupo21.sci.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo21.sci.entities.Usuario;
import com.unla.grupo21.sci.entities.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
	
	public List<Venta> findByUsuario(Usuario usuario);

}
