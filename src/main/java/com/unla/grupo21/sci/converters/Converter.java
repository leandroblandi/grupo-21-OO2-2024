package com.unla.grupo21.sci.converters;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Esta clase realiza la conversión entre dos clases de modelo, generalmente
 * entre un DTO y una entidad, o viceversa
 * 
 * @param <T> La entidad de entrada
 * @param <Y> La entidada/modelo/dto de salida
 */
public abstract class Converter<T, Y> {

	public List<T> convertList(List<Y> models) {
		return Optional.ofNullable(models).orElse(Collections.emptyList()).stream().map(this::convert)
				.collect(Collectors.toList());
	}

	public List<Y> unconvertList(List<T> models) {
		return Optional.ofNullable(models).orElse(Collections.emptyList()).stream().map(this::unconvert)
				.collect(Collectors.toList());
	}

	public T convert(Y model) {
		if (model == null)
			return null;
		return convertModel(model);
	}

	public Y unconvert(T model) {
		if (model == null)
			return null;
		return unconvertModel(model);
	}

	protected abstract T convertModel(Y model);

	protected abstract Y unconvertModel(T model);

}