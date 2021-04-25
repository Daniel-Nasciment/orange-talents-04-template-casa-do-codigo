package com.orange.casa.codigo.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;

	@Deprecated
	public Pais() {

	}

	public Pais(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

}
