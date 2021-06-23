package br.com.zup.transacao.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.transacao.entity.Transacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;
	
	public TransacaoResponse() {
	}

	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.estabelecimento = transacao.converteEstabelecimento();
		this.cartao = transacao.converterCartao();
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public static Page<TransacaoResponse> converter(Page<Transacao> transacoes) {
		return transacoes.map(TransacaoResponse::new);
	}
}
