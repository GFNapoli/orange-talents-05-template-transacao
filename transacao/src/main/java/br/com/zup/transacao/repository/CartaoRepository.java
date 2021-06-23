package br.com.zup.transacao.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.transacao.entity.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, String>{

}
