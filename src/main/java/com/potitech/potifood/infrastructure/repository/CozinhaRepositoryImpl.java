package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.repository.CozinhaRepository;


@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cozinha> list() {
		return entityManager.createQuery("from Cozinha", Cozinha.class).getResultList();	
	}

	@Override
	public Cozinha findById(Long id) {
		return entityManager.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public Cozinha createOrUpdate(Cozinha cozinha) {
		return entityManager.merge(cozinha);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Cozinha cozinha = findById(id);
		
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(cozinha);
	}

}
