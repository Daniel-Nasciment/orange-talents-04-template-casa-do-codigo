package com.orange.casa.codigo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.orange.casa.codigo.Modelo.Autor;
import com.orange.casa.codigo.Modelo.Categoria;
import com.orange.casa.codigo.Modelo.Livro;
import com.orange.casa.codigo.repository.AutorRepository;
import com.orange.casa.codigo.repository.CategoriaRepository;
import com.orange.casa.codigo.validator.UniqueValue;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numPaginas;

	@NotBlank
	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@Future
	@NotNull
	private LocalDate dataLancamento;

	@NotNull
	private Long idCategoria;

	@NotNull
	private Long idAutor;

	public LivroForm(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numPaginas, @NotBlank String isbn,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Livro converteLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {

		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		Autor autor = autorRepository.findById(idAutor).get();

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numPaginas, this.isbn,
				this.dataLancamento, categoria, autor);
	}

}
