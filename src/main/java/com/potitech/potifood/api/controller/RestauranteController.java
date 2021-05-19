package com.potitech.potifood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping
	public List<Restaurante> listar() {
		return cadastroRestaurante.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id){
		Restaurante restaurante = cadastroRestaurante.buscar(id);

		return restaurante != null ? ResponseEntity.status(HttpStatus.OK).body(restaurante)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
