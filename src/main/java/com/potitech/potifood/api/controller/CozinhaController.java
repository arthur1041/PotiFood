package com.potitech.potifood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.potitech.potifood.domain.exception.EntidadeNaoEncontradaException;
import com.potitech.potifood.domain.exception.ErroAoRemoverException;
import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.service.CrudCozinhaService;

//@Controller
//@ResponseBody
//rest controller substitui as anotações 'Controller' e 'ResponseBody'
@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CrudCozinhaService crudCozinha;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Cozinha> listar() {
		return crudCozinha.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = crudCozinha.buscar(id);

		return cozinha != null ? ResponseEntity.status(HttpStatus.OK).body(cozinha)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return crudCozinha.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<?> atualizar(@PathVariable("cozinhaId") Long id, @RequestBody Cozinha cozinha) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(crudCozinha.atualizar(id, cozinha));
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable("cozinhaId") Long id) {
		try {
			
			crudCozinha.remover(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
		} catch (ErroAoRemoverException e) {
		
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		
		}
	}
}
