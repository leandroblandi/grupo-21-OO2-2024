package com.unla.grupo21.sci.services.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo21.sci.dtos.ArticuloDiasDto;
import com.unla.grupo21.sci.dtos.ArticuloDto;
import com.unla.grupo21.sci.entities.Articulo;
import com.unla.grupo21.sci.exceptions.NoEncontradoException;
import com.unla.grupo21.sci.exceptions.YaExisteException;
import com.unla.grupo21.sci.repositories.IArticuloRepository;
import com.unla.grupo21.sci.services.IArticuloService;

import jakarta.transaction.Transactional;

@Service
public class ArticuloService implements IArticuloService {
	
	@Autowired
	private IArticuloRepository articuloRepository;

	@Override
	public List<Articulo> traerArticulos() {
		return articuloRepository.findAll();
	}

	@Override
	public Articulo traerArticulo(long id) {

		Optional<Articulo> articuloOptional = articuloRepository.findById(id);

		if (articuloOptional.isEmpty()) {
			throw new NoEncontradoException(id);
		}

		return articuloOptional.get();
	}

	@Override
	@Transactional
	public Articulo crearArticulo(Articulo articulo) {
		Optional<Articulo> articuloOptional = articuloRepository.findById(articulo.getIdArticulo());

		if (articuloOptional.isPresent()) {
			throw new YaExisteException(articuloOptional.get().getIdArticulo());
		}
		articulo.setEstaEnUnLote(false);
		Articulo articuloDb = articuloRepository.save(articulo);

		return articuloDb;
	}

	@Transactional
	@Override
	public Articulo modificarArticulo(long id, ArticuloDto articuloDto) {
		Articulo articulo = traerArticulo(id);

		articulo.setCosto(articuloDto.getCosto());
		articulo.setDescripcion(articuloDto.getDescripcion());
		articulo.setPrecioVenta(articuloDto.getPrecioVenta());

		return articuloRepository.save(articulo);
	}

	@Override
	public Articulo borrarArticulo(Articulo articulo) {
		traerArticulo(articulo.getIdArticulo());
		articulo.setActivo(false);
		return articuloRepository.save(articulo);
	}
	
	@Override
	public List<ArticuloDiasDto> traerArticulosConMasDias(int dias){
		List<Articulo> listaArticulo= articuloRepository.findAll();
		List<ArticuloDiasDto> listaArticuloMasViejos= new ArrayList<>();

		for (Articulo articulo : listaArticulo) {
			//devuelve la cantidad de dias de vida del Articulo 
			long diasArticulo= ChronoUnit.DAYS.between(articulo.getFechaCreacion(), LocalDateTime.now());
			if(diasArticulo >= dias) {
				listaArticuloMasViejos.add(ArticuloDiasDto.builder().nombreArticulo(articulo.getDescripcion()).dias(diasArticulo).build());
			}
		}
		
		return listaArticuloMasViejos;
	}

}
