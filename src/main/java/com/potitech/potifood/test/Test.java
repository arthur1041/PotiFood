package com.potitech.potifood.test;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.potitech.potifood.PotifoodApiApplication;
import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.infrastructure.repository.RestauranteRepositoryImpl;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new SpringApplicationBuilder(PotifoodApiApplication.class).web(WebApplicationType.NONE).run(args);
//
//		RestauranteRepositoryImpl restauranteRepositoryImpl = applicationContext.getBean(RestauranteRepositoryImpl.class);
//		List<Restaurante> restaurantes = restauranteRepositoryImpl.findByCozinha(new Cozinha(10l, "a"));
//		
//		for (Restaurante restaurante : restaurantes) {
//			System.out.println(restaurante);
//		}
	}
}
