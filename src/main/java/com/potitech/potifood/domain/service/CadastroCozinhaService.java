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
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.createOrUpdate(cozinha);
	}

	public Cozinha buscar(Long id) {
		return cozinhaRepository.findById(id);
	}

	public List<Cozinha> listar() {
		return cozinhaRepository.list();
	}

	public void remover(Long id) {
		List<Restaurante> restaurantes = restauranteRepository.findByCozinha(id);

		try {
			for (Restaurante restaurante : restaurantes) {
				restauranteRepository.delete(restaurante);
			}
			cozinhaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Não existe um cadastro de cozinha com código " + id);
		} catch (DataIntegrityViolationException e) {
			throw new ErroAoRemoverException("Cozinha de código " + id + " não pode ser removida.");
		}
	}
}
