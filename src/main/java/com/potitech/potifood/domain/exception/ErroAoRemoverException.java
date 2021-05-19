package com.potitech.potifood.domain.exception;

public class ErroAoRemoverException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ErroAoRemoverException() {
		super("Erro ao remover registro");
	}
	
	public ErroAoRemoverException(String mensagem) {
		super(mensagem);
	}
	
}
