package br.com.zup.transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.client.ApiCartoes;
import br.com.zup.transacao.exception.TransacaoRequestException;
import br.com.zup.transacao.request.CartaoRequest;
import feign.FeignException;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	private ApiCartoes apiCartoes;
	
	@PostMapping
	public ResponseEntity<?> estimuloTransacao(@RequestBody CartaoRequest cartao){
		
		try {
			apiCartoes.estimulo(cartao);
		} catch (FeignException e) {
			throw new TransacaoRequestException(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeEstimulo(@PathVariable String id){
		
		try {
			apiCartoes.remosverEstimulo(id);
		} catch (FeignException e) {
			throw new TransacaoRequestException(e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY);
		}
		
		return ResponseEntity.ok().build();
	}
}
