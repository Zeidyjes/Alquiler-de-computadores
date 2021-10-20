package com.g30.alquiler.computadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@EntityScan(basePackages = {"com.g30.alquiler.computadores.modelo"})
@SpringBootApplication
public class AlquilercomputadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquilercomputadoresApplication.class, args);
	}

}
