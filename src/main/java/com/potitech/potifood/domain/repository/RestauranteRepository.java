package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> list();
	Restaurante findById(Long id);
	Restaurante createOrUpdate(Restaurante restaurante);
	void delete(Restaurante restaurante);
	List<Restaurante> findByCozinha(Long cozinhaId);
	
}
