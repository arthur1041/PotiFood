package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Estado;
import com.potitech.potifood.domain.repository.EstadoRepository;


@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Estado> list() {
		return entityManager.createQuery("from Estado", Estado.class).getResultList();	
	}

	@Override
	public Estado findById(Long id) {
		return entityManager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado createOrUpdate(Estado estado) {
		return entityManager.merge(estado);
	}

	@Override
	@Transactional
	public void delete(Estado estado) {
		entityManager.remove(estado);
	}

}
