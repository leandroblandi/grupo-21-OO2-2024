package com.unla.grupo21.sci.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.grupo21.sci.configuration.SimpleGrantedAuthorityJsonCreator;
import com.unla.grupo21.sci.configuration.TokenJwtConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValidacionJwtFilter extends BasicAuthenticationFilter {
	
	public ValidacionJwtFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader(TokenJwtConfiguration.HEADER_AUTHORIZATION);
		
		if(header == null || !header.startsWith(TokenJwtConfiguration.PREFIX_TOKEN)) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = header.replace(TokenJwtConfiguration.PREFIX_TOKEN, "");
		
		/**
		 * Aquí es donde se obtienen los claims, y se verifica el token,
		 * una vez realizada la validación, se sigue la cadena de filtros
		 */
		try {
			Claims claims = Jwts.parser().verifyWith(TokenJwtConfiguration.SECRET_KEY).build().parseSignedClaims(token).getPayload();
			
			String usuario = claims.getSubject();
			Collection<? extends GrantedAuthority> roles = Arrays.asList(new ObjectMapper()
					.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityJsonCreator.class)
					.readValue(claims.get("authorities").toString().getBytes(), SimpleGrantedAuthority[].class));

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, roles);
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			chain.doFilter(request, response);
					
			
		/**
		 * Si no se pudo autenticar,
		 * devuelve un JWT Exception
		 */
		} catch (JwtException e) {
			Map<String, String> json = new HashMap<String, String>();
			json.put("error", e.getMessage());	
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType(TokenJwtConfiguration.CONTENT_TYPE);
		}
	}

}
