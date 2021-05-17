package com.potitech.potifood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.potitech.potifood.PotifoodApiApplication;
import com.potitech.potifood.domain.model.entities.Cozinha;

public class InclusaoCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(PotifoodApiApplication.class).web(WebApplicationType.NONE).run(args);
	
		CadastroCozinha ca = applicationContext.getBean(CadastroCozinha.class);
	
		Cozinha c = ca.buscar(1L);
		
		ca.remover(c);
	}
}
