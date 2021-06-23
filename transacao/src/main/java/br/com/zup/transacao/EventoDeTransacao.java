package br.com.zup.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.transacao.entity.Cartao;
import br.com.zup.transacao.entity.Estabelecimento;
import br.com.zup.transacao.entity.Transacao;
import br.com.zup.transacao.request.CartaoRequest;
import br.com.zup.transacao.request.EstabelecimentoRequest;

public class EventoDeTransacao {

	private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;
    private LocalDateTime efetivadaEm;
    
	public EventoDeTransacao() {
	}

	public EventoDeTransacao(String id, BigDecimal valor, EstabelecimentoRequest estabelecimento, CartaoRequest cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstabelecimentoRequest getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoRequest estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CartaoRequest getCartao() {
		return cartao;
	}

	public void setCartao(CartaoRequest cartao) {
		this.cartao = cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public void setEfetivadaEm(LocalDateTime efetivadaEm) {
		this.efetivadaEm = efetivadaEm;
	}

	public Transacao converter() {
		Estabelecimento estabelecimento = this.estabelecimento.converter();
		Cartao cartao = this.cartao.converter(); 
		return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
	}  
    
}
