package br.com.zup.transacao.exception;

import org.springframework.http.HttpStatus;

public class TransacaoRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	
	public TransacaoRequestException(String mensagem,HttpStatus status) {
		super(mensagem);
		this.status = status;
	}

	public TransacaoRequestException(String mensagem, Throwable causa, HttpStatus status) {
		super(mensagem, causa);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
