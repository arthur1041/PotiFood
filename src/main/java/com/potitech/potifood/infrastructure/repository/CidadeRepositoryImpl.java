package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Cidade;
import com.potitech.potifood.domain.repository.CidadeRepository;


@Component
public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cidade> list() {
		return entityManager.createQuery("from Cidade", Cidade.class).getResultList();	
	}

	@Override
	public Cidade findById(Long id) {
		return entityManager.find(Cidade.class, id);
	}

	@Override
	@Transactional
	public Cidade createOrUpdate(Cidade cidade) {
		return entityManager.merge(cidade);
	}

	@Override
	@Transactional
	public void delete(Cidade cidade) {
		entityManager.remove(cidade);
	}

}
