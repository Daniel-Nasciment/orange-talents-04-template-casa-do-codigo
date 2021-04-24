package com.orange.casa.codigo.dto;

import com.orange.casa.codigo.Modelo.Autor;

public class DetalheAutorDto {

	private String nome;
	private String descricao;

	public DetalheAutorDto(Autor autor) {

		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();

	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
