package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.FormaPagamento;
import com.potitech.potifood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<FormaPagamento> list() {
		return entityManager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();	
	}

	@Override
	public FormaPagamento findById(Long id) {
		return entityManager.find(FormaPagamento.class, id);
	}

	@Override
	@Transactional
	public FormaPagamento createOrUpdate(FormaPagamento formaPagamento) {
		return entityManager.merge(formaPagamento);
	}

	@Override
	@Transactional
	public void delete(FormaPagamento formaPagamento) {
		entityManager.remove(formaPagamento);
	}

}
