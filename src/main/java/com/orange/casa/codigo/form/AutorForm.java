package com.orange.casa.codigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.orange.casa.codigo.Aluno.Autor;

public class AutorForm {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Length(max = 400)
	private String descricao;

	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converteAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "AutorForm [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}

}
