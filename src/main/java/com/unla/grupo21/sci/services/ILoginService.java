package com.unla.grupo21.sci.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.unla.grupo21.sci.dtos.TokenResponseDto;

public interface ILoginService {
	public TokenResponseDto login(String usuario, String clave);

	public List<SimpleGrantedAuthority> giveAuthorities(String usuario);
}
