package com.potitech.potifood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.potitech.potifood.PotifoodApiApplication;
import com.potitech.potifood.domain.model.entities.Cozinha;

public class ExclusaoCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(PotifoodApiApplication.class).web(WebApplicationType.NONE).run(args);
	
		CadastroCozinha ca = applicationContext.getBean(CadastroCozinha.class);
	
		Cozinha cozinha1 = new Cozinha(null, "Brasileira");
		Cozinha cozinha2 = new Cozinha(null, "Japonesa");
		
		ca.salvar(cozinha1);
		ca.salvar(cozinha2);
	}
}
