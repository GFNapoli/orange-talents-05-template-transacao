package br.com.zup.transacao.request;

import br.com.zup.transacao.entity.Estabelecimento;

public class EstabelecimentoRequest {

	private String nome;
	private String cidade;
	private String endereco;
	
	public EstabelecimentoRequest() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Estabelecimento converter() {
		return new Estabelecimento(nome, cidade, endereco);
	}
	
}
