package com.startU.covoiturage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
public class CovoiturageApplication {

	//Allow Cross origin for http://localhost:4200
	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization"));
		config.setAllowedMethods(Arrays.asList("GET","POST"));
		source.registerCorsConfiguration("/**",config);

		return new org.springframework.web.filter.CorsFilter(source);
	}

	public static void main(String[] args) {

		SpringApplication.run(CovoiturageApplication.class, args);
	}

}
