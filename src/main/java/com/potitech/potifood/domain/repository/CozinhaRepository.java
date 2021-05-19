package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> list();
	Cozinha findById(Long id);
	Cozinha createOrUpdate(Cozinha cozinha);
	void delete(Long id);
	
}
