package com.orange.casa.codigo.dto;

import java.math.BigDecimal;

import com.orange.casa.codigo.Modelo.Livro;

public class DetalheLivroDto {

	private String titulo;
	private DetalheAutorDto autor;
	private String isbn;
	private Integer numPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	
	@Deprecated
	public DetalheLivroDto() {
		
	}

	public DetalheLivroDto(Livro livro) {
		titulo = livro.getTitulo();
		autor = new DetalheAutorDto(livro.getAutor());
		isbn = livro.getIsbn();
		numPaginas = livro.getNumPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();

	}

	public String getTitulo() {
		return titulo;
	}

	public DetalheAutorDto getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

}
