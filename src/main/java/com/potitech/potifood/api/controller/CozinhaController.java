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
import com.potitech.potifood.domain.service.CadastroCozinhaService;
import com.potitech.potifood.domain.service.CadastroRestauranteService;

//@Controller
//@ResponseBody
//rest controller substitui as anotações 'Controller' e 'ResponseBody'
@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@GetMapping
	public List<Cozinha> listar() {
		return cadastroCozinha.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cadastroCozinha.buscar(id);

		return cozinha != null ? ResponseEntity.status(HttpStatus.OK).body(cozinha)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable("cozinhaId") Long id, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cadastroCozinha.buscar(id);

		if (cozinhaAtual != null) {
			cozinhaAtual.setNome(cozinha.getNome());

			cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);

			return ResponseEntity.status(HttpStatus.OK).body(cozinhaAtual);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable("cozinhaId") Long id) {
		try {
			
			cadastroCozinha.remover(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
					;
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
		} catch (ErroAoRemoverException e) {
		
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		
		}
	}
}
