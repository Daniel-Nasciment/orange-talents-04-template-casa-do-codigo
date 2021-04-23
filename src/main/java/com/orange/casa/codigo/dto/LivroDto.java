package com.orange.casa.codigo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.orange.casa.codigo.Modelo.Livro;

public class LivroDto {

	private Long id;
	private String titulo;

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	@Deprecated
	public LivroDto() {
		
	}

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public static List<LivroDto> converterDto(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}
}
