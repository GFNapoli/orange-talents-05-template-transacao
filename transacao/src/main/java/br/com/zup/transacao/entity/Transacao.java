package br.com.zup.transacao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zup.transacao.response.CartaoResponse;
import br.com.zup.transacao.response.EstabelecimentoResponse;

@Entity
public class Transacao {

	@Id
	private String id;
	private BigDecimal valor;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Estabelecimento estabelecimento;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Cartao cartao;
	private LocalDateTime efetivadaEm;
	
	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public Transacao() {
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public EstabelecimentoResponse converteEstabelecimento() {
		return new EstabelecimentoResponse(this.estabelecimento.getNome(), this.estabelecimento.getCidade(), this.estabelecimento.getEndereco());
	}

	public CartaoResponse converterCartao() {
		return new CartaoResponse(this.cartao.getId(), this.cartao.getEmail());
	}
	
	
}
