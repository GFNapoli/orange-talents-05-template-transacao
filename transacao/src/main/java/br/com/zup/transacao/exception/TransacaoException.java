package br.com.zup.transacao.exception;

import org.springframework.http.HttpStatus;

public class TransacaoException {

	private final HttpStatus status;
	private final String menssagem;
	
	public TransacaoException(HttpStatus status, String menssagem) {
		this.status = status;
		this.menssagem = menssagem;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMenssagem() {
		return menssagem;
	}
	
	
}
