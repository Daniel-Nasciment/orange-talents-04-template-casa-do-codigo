package com.orange.casa.codigo.form;

import javax.validation.constraints.NotBlank;

import com.orange.casa.codigo.Modelo.Categoria;
import com.orange.casa.codigo.validator.UniqueValue;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
