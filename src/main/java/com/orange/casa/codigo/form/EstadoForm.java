package com.orange.casa.codigo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orange.casa.codigo.Modelo.Estado;
import com.orange.casa.codigo.Modelo.Pais;
import com.orange.casa.codigo.repository.PaisRepository;
import com.orange.casa.codigo.validator.UniqueValue;

public class EstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	@NotNull
	private Long idPais;

	public EstadoForm(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado ConverteEstado(PaisRepository paisRepository) {

		Pais pais = paisRepository.findById(idPais).get();

		return new Estado(this.nome, pais);

	}

}
