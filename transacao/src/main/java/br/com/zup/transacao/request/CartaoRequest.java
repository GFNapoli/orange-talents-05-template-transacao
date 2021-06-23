package br.com.zup.transacao.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.transacao.entity.Cartao;

public class CartaoRequest {

	@NotBlank
	private String id;
	
	@NotBlank
	@Email
	private String email;
	
	public CartaoRequest() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Cartao converter() {
		return new Cartao(id, email);
	}
	
	
}
