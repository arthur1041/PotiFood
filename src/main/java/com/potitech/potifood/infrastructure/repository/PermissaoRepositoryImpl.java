package com.potitech.potifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Permissao;
import com.potitech.potifood.domain.repository.PermissaoRepository;


@Component
public class PermissaoRepositoryImpl implements PermissaoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Permissao> list() {
		return entityManager.createQuery("from Permissao", Permissao.class).getResultList();	
	}

	@Override
	public Permissao findById(Long id) {
		return entityManager.find(Permissao.class, id);
	}

	@Override
	@Transactional
	public Permissao createOrUpdate(Permissao permissao) {
		return entityManager.merge(permissao);
	}

	@Override
	@Transactional
	public void delete(Permissao permissao) {
		entityManager.remove(permissao);
	}

}
