package br.com.zup.transacao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.transacao.request.CartaoRequest;
import feign.Headers;

@FeignClient(name = "apiCartoes", url = "${cartoes.host}")
public interface ApiCartoes {

	@PostMapping
	@Headers("Content-Type: application/json")
	void estimulo(CartaoRequest cartao);
	
	@DeleteMapping("/{id}")
	void remosverEstimulo(@PathVariable String id);
}
