package br.com.zup.transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.client.ApiCartoes;
import br.com.zup.transacao.entity.Cartao;
import br.com.zup.transacao.entity.Transacao;
import br.com.zup.transacao.exception.TransacaoRequestException;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;
import br.com.zup.transacao.request.CartaoRequest;
import br.com.zup.transacao.response.TransacaoResponse;
import feign.FeignException;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	private ApiCartoes apiCartoes;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
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
	
	@GetMapping("/{id}")
	public Page<TransacaoResponse> buscaUltimasTransacoes(@PathVariable String id, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		Cartao cartao = cartaoRepository.findById(id).orElseThrow(
				() -> new TransacaoRequestException("Cartão não consta no sistema!", HttpStatus.NOT_FOUND));
		
		Page<Transacao> transacoes = transacaoRepository.findByCartaoId(cartao.getId(), paginacao);
		
		return TransacaoResponse.converter(transacoes);
	}
}
