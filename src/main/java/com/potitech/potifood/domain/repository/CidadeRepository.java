package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.Cidade;

public interface CidadeRepository {

	List<Cidade> list();
	Cidade findById(Long id);
	Cidade createOrUpdate(Cidade cidade);
	void delete(Long id);
	
}
