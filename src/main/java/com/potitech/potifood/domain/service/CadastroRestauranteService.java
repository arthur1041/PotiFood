package com.potitech.potifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.createOrUpdate(restaurante);
	}
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.findById(id);
	}
	
	public List<Restaurante> listar() {
		return restauranteRepository.list();
	}
	
	public void remover(Restaurante restaurante) {
		restauranteRepository.delete(restaurante);
	}
	
	public List<Restaurante> buscarPorCozinha(Cozinha cozinha) {
		return restauranteRepository.findByCozinha(cozinha);
	}
}
