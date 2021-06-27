package com.potitech.potifood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEncontradaException(Class<?> _class, Long id) {
		super("Não foi encontrado nenhum registro de " + _class.getSimpleName().toLowerCase() + " com código " + id);
	}
	
	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
