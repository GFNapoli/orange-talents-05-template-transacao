package br.com.zup.transacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import br.com.zup.transacao.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, String>{

	Page<Transacao> findByCartaoId(String id, Pageable paginacao);

}
