package com.orange.casa.codigo.form;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

	@NotBlank
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "CategoriaForm [nome=" + nome + "]";
	}

}
