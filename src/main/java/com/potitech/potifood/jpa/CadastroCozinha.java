package com.potitech.potifood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.potitech.potifood.domain.model.entities.Cozinha;

@Component
public class CadastroCozinha {

	@Autowired
	private EntityManager manager;
	
	public List<Cozinha> listar(){
		
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void remover(Cozinha cozinha) {
		manager.remove(cozinha);
	}
}
