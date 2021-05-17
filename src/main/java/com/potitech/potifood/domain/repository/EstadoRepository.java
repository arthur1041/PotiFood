package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.Estado;

public interface EstadoRepository {

	List<Estado> list();
	Estado findById(Long id);
	Estado createOrUpdate(Estado cozinha);
	void delete(Estado cozinha);
	
}
