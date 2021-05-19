package com.potitech.potifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potitech.potifood.domain.model.entities.Cozinha;
import com.potitech.potifood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.createOrUpdate(cozinha);
	}
	
	public Cozinha buscar(Long id) {
		return cozinhaRepository.findById(id);
	}
	
	public List<Cozinha> listar() {
		return cozinhaRepository.list();
	}
	
	public void remover(Cozinha cozinha) {
		cozinhaRepository.delete(cozinha);
	}
}
