package com.potitech.potifood.domain.repository;

import java.util.List;

import com.potitech.potifood.domain.model.entities.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> list();
	FormaPagamento findById(Long id);
	FormaPagamento createOrUpdate(FormaPagamento formaPagamento);
	void delete(FormaPagamento formaPagamento);
	
}
