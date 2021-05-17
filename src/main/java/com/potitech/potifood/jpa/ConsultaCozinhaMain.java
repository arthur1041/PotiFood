package com.potitech.potifood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.potitech.potifood.PotifoodApiApplication;
import com.potitech.potifood.domain.model.entities.Cozinha;

public class ConsultaCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(PotifoodApiApplication.class).web(WebApplicationType.NONE).run(args);
	
		CadastroCozinha ca = applicationContext.getBean(CadastroCozinha.class);
	
		List<Cozinha> cozinhas = ca.listar();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha);
		}
		
		System.out.println(ca.buscar(1l));
	}
}
