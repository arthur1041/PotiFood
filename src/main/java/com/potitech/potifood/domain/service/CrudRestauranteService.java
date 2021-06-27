package com.potitech.potifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.potitech.potifood.domain.exception.EntidadeNaoEncontradaException;
import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.repository.CozinhaRepository;
import com.potitech.potifood.domain.repository.RestauranteRepository;

@Service
public class CrudRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId);

		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException("Não existe registro de cozinha com código " + cozinhaId);
		}

		restaurante.setCozinha(cozinha);

		return restauranteRepository.createOrUpdate(restaurante);
	}

	public Restaurante atualizar(Long id, Restaurante restaurante) {
		Restaurante restauranteAtual = restauranteRepository.findById(id);

		if (restauranteAtual == null) {
			throw new EntidadeNaoEncontradaException("Não existe registro de restaurante com código " + id);
		}

		Cozinha cozinha = null;

		if (restaurante.getCozinha() != null) {
			cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId());

			if (cozinha == null) {
				throw new EntidadeNaoEncontradaException(
						"Não existe registro de cozinha com código " + restaurante.getCozinha().getId());
			}
		}

		if (restaurante.getNome() != null) {
			restauranteAtual.setNome(restaurante.getNome());
		}

		if (restaurante.getTaxaFrete() != null) {
			restauranteAtual.setTaxaFrete(restaurante.getTaxaFrete());
		}

		if (cozinha != null) {
			restauranteAtual.setCozinha(cozinha);
		}

		restaurante = restauranteRepository.createOrUpdate(restauranteAtual);

		return restaurante;
	}

	public Restaurante buscar(Long id) {
		Restaurante restaurante = restauranteRepository.findById(id);

		if (restaurante == null) {
			throw new EntidadeNaoEncontradaException(Restaurante.class, id);
		}

		return restaurante;
	}

	public List<Restaurante> listar() {
		return restauranteRepository.list();
	}

	public void remover(Long id) {
		try {
			restauranteRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(Restaurante.class, id);
		}
	}

}
