package com.unla.grupo21.sci.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo21.sci.entities.Almacenamiento;

// Long va con 'L' mayus (porque debe ser un objeto)
@Repository
public interface IAlmacenamientoRepository extends JpaRepository<Almacenamiento, Long> {

}
