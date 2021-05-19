package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.model.entities.Restaurante;
import com.potitech.potifood.domain.repository.RestauranteRepository;


@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Restaurante> list() {
		return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();	
	}

	@Override
	public Restaurante findById(Long id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante createOrUpdate(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}

	@Override
	@Transactional
	public void delete(Restaurante restaurante) {
		entityManager.remove(restaurante);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurante> findByCozinha(Long cozinhaId) {
		Query query = entityManager.createQuery("from Restaurante restaurante WHERE restaurante.cozinha.id = :cozinhaId");
		query.setParameter("cozinhaId", cozinhaId);
		
		return query.getResultList();
	}

}
