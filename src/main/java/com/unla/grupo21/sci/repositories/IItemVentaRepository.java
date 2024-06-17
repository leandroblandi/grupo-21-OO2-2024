package com.unla.grupo21.sci.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo21.sci.entities.ItemVenta;

@Repository
public interface IItemVentaRepository extends JpaRepository<ItemVenta, Long> {

	
	
	@Query("SELECT iv.articulo, SUM(iv.cantidad) as totalCantidad " +
	           "FROM ItemVenta iv " +
	           "GROUP BY iv.articulo " +
	           "ORDER BY totalCantidad DESC")
	    List<Object[]> traerArticulosMasVendidos();
	
}
