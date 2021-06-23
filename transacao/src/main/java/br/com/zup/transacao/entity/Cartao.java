package br.com.zup.transacao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

	@Id
	private String id;
	
	@Email
	private String email;

	public Cartao(String id, @Email String email) {
		this.id = id;
		this.email = email;
	}

	public Cartao() {
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
}
