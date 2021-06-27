package com.potitech.potifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.potitech.potifood.domain.exception.EntidadeNaoEncontradaException;
import com.potitech.potifood.domain.model.entities.Cidade;
import com.potitech.potifood.domain.model.entities.Estado;
import com.potitech.potifood.domain.repository.CidadeRepository;
import com.potitech.potifood.domain.repository.EstadoRepository;

@Service
public class CrudEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public Estado salvar(Estado estado) {
		return estadoRepository.createOrUpdate(estado);
	}

	public Estado atualizar(Long id, Estado estado) {
		Estado estadoAtual = estadoRepository.findById(id);

		if (estadoAtual == null) {
			throw new EntidadeNaoEncontradaException(
					"Não foi encontrado nenhum registro de estado com código " + id + " para ser atualizado.");
		}

		estadoAtual.setNome(estado.getNome());
		
		estado = estadoRepository.createOrUpdate(estadoAtual);

		return estado;
	}

	public Estado buscar(Long id) {
		Estado estado = estadoRepository.findById(id);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException("Não foi encontrado nenhum registro de estado com código " + id);
		}
		
		return estado;
				
	}

	public List<Estado> listar() {
		return estadoRepository.list();
	}

	public void remover(Long id) {
		Estado estado = estadoRepository.findById(id);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(Estado.class, id);
		}
		
		List<Cidade> cidades = estado.getCidades();
		
		try {
			
			for (Cidade cidade : cidades) {
				cidadeRepository.delete(cidade.getId());
			}
			
			estadoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Não existe um registro de estado com código " + id);
		}
	}

}
