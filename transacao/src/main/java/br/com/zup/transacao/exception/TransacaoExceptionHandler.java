package br.com.zup.transacao.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransacaoExceptionHandler {

	@ExceptionHandler(value = TransacaoRequestException.class)
	public ResponseEntity<Object> transacaoHandlerException(TransacaoRequestException e){
		
		TransacaoException exception = new TransacaoException(e.getStatus(), e.getMessage());
		return new ResponseEntity<>(exception, e.getStatus());
	}
}
