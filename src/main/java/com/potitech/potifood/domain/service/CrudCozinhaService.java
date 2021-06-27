package com.potitech.potifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.potitech.potifood.domain.exception.EntidadeNaoEncontradaException;
import com.potitech.potifood.domain.exception.ErroAoRemoverException;
import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.repository.CozinhaRepository;
import com.potitech.potifood.domain.repository.RestauranteRepository;

@Service
public class CrudCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.createOrUpdate(cozinha);
	}
	
	public Cozinha atualizar(Long id, Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.findById(id);
		
		if(cozinhaAtual == null) {
			throw new EntidadeNaoEncontradaException("Não foi encontrado nenhum registro de cozinha com código " + id + " para ser atualizado.");
		}
		
		cozinhaAtual.setNome(cozinha.getNome());
		
		cozinha = cozinhaRepository.createOrUpdate(cozinhaAtual);
		
		return cozinha;
	}

	public Cozinha buscar(Long id) {
		Cozinha cozinha = cozinhaRepository.findById(id);
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(Cozinha.class, id);	
		}
		
		return cozinha;
	}

	public List<Cozinha> listar() {
		return cozinhaRepository.list();
	}

	public void remover(Long id) {
		Cozinha cozinha = cozinhaRepository.findById(id);
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(Cozinha.class, id);
		}
		
		List<Restaurante> restaurantes = cozinha.getRestaurantes();

		try {
			for (Restaurante restaurante : restaurantes) {
				restauranteRepository.delete(restaurante.getId());
			}
			cozinhaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) { //caso da cozinha não existir
			throw new EntidadeNaoEncontradaException("Não existe um cadastro de cozinha com código " + id);
		} catch (DataIntegrityViolationException e) { //caso de chave estrangeira
			throw new ErroAoRemoverException("Cozinha de código " + id + " não pode ser removida.");
		}
	}
}
