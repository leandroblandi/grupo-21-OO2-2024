package com.unla.grupo21.sci.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.unla.grupo21.sci.filters.ValidacionJwtFilter;
import com.unla.grupo21.sci.services.impl.UsuarioService;

/***
 * Clase de configuracion para la seguridad de la aplicacion. Indica que rutas
 * están permitidas, y cuáles requieren autenticación. También indica el método
 * de autenticación mediante el `UserService`
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	@Autowired
	@Lazy
	private UsuarioService userService;

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		AuthenticationManager authenticationManager = authenticationManager(authenticationConfiguration);

		return http.authorizeHttpRequests(auth -> {
			auth.requestMatchers(HttpMethod.GET, "/api/status").permitAll();
			auth.requestMatchers(HttpMethod.POST, "/api/login").permitAll();
			auth.requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll();
			auth.requestMatchers("/api/lotes").hasRole("ADMINISTRADOR");
			auth.requestMatchers("/api/roles").hasRole("ADMINISTRADOR");
			auth.requestMatchers(HttpMethod.GET, "/api/ventas").hasRole("ADMINISTRADOR");
			auth.requestMatchers(HttpMethod.POST, "/api/articulos").hasRole("ADMINISTRADOR");
			auth.anyRequest().authenticated();
		}).csrf(config -> config.disable()).cors(config -> config.configurationSource(corsConfigurationSource()))
				.addFilter(new ValidacionJwtFilter(authenticationManager))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userService);
		return provider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
