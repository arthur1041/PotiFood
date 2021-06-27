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
public class CrudCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.createOrUpdate(cidade);
	}

	public Cidade atualizar(Long id, Cidade cidade) {
		Cidade cidadeAtual = cidadeRepository.findById(id);

		if (cidadeAtual == null) {
			throw new EntidadeNaoEncontradaException(Cidade.class, id);
		}

		Estado estado = null;
		
		if (cidade.getEstado() != null) {
			estado = estadoRepository.findById(cidade.getEstado().getId());

			if (estado == null) {
				throw new EntidadeNaoEncontradaException(Estado.class, cidade.getEstado().getId());
			}
		}
		
		if (cidade.getNome() != null) {
			cidadeAtual.setNome(cidade.getNome());
		}
		if (estado != null) {
			cidadeAtual.setEstado(estado);
		}

		return cidadeRepository.createOrUpdate(cidadeAtual);
	}

	public Cidade buscar(Long id) {
		Cidade cidade = cidadeRepository.findById(id);

		if (cidade == null) {
			throw new EntidadeNaoEncontradaException(Cidade.class, id);
		}

		return cidade;
	}

	public List<Cidade> listar() {
		return cidadeRepository.list();
	}

	public void remover(Long id) {
		try {
			cidadeRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(Cidade.class, id);
		}
	}

}
