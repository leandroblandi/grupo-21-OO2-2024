package com.unla.grupo21.sci.configuration;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

/**
 * Esta clase contiene algunos atributos utiles para la configuracion de
 * seguridad, relacionado a la generacion del Token JWT
 */
public class TokenJwtConfiguration {
	public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
	public static final String PREFIX_TOKEN = "Bearer ";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String CONTENT_TYPE = "application/json";
	public static final Long TOKEN_DURATION_SEGS = 3600000L;

}
