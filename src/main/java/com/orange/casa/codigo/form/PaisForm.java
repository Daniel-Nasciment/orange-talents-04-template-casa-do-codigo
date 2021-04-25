package com.orange.casa.codigo.form;

import javax.validation.constraints.NotBlank;

import com.orange.casa.codigo.Modelo.Pais;
import com.orange.casa.codigo.validator.UniqueValue;

public class PaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PaisForm [nome=" + nome + "]";
	}

}
