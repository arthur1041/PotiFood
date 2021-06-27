package com.potitech.potifood.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.potitech.potifood.PotifoodApiApplication;
import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.repository.CozinhaRepository;
import com.potitech.potifood.infrastructure.repository.CozinhaRepositoryImpl;
import com.potitech.potifood.infrastructure.repository.RestauranteRepositoryImpl;

public class Test {
	
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(PotifoodApiApplication.class).web(WebApplicationType.NONE).run(args);

//		EntityManager entityManager = applicationContext.getBean(EntityManager.class);
////		
//		List<Restaurante> objs = (List<Restaurante>) entityManager.createQuery("DELETE restaurante from Restaurante restaurante inner join restaurante.cozinha where restaurante.cozinha.id = 1").getResultList();
////		
//		for (Object object : objs) {
//			System.out.println(object);
//		}
		
		
//		RestauranteRepositoryImpl restauranteRepositoryImpl = applicationContext.getBean(RestauranteRepositoryImpl.class);
//		List<Restaurante> restaurantes = restauranteRepositoryImpl.findByCozinha(1l);
//		
//		for (Restaurante restaurante : restaurantes) {
//			System.out.println(restaurante);
//		}
		
		CozinhaRepositoryImpl cozinhaRepositoryImpl = applicationContext.getBean(CozinhaRepositoryImpl.class);
		
		Cozinha cozinha = cozinhaRepositoryImpl.findById(1L);
		
		List<Restaurante> restaurantes = cozinha.getRestaurantes();
		
		for (Restaurante restaurante : restaurantes) {
			System.out.println(restaurante);
		}
		
		System.out.println("----------------------------");
		
		Restaurante restaurante = cozinha.getRestaurante(2l);
		
		System.out.println(restaurante.getCozinha().getRestaurante(1l));
		
	}
}
