package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.Permissao;

public interface PermissaoRepository {

	List<Permissao> list();
	Permissao findById(Long id);
	Permissao createOrUpdate(Permissao permissao);
	void delete(Permissao permissao);
	
}
