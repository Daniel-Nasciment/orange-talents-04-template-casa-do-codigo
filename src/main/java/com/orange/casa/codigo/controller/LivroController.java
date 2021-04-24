package com.orange.casa.codigo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Livro;
import com.orange.casa.codigo.dto.DetalheLivroDto;
import com.orange.casa.codigo.dto.LivroDto;
import com.orange.casa.codigo.form.LivroForm;
import com.orange.casa.codigo.repository.AutorRepository;
import com.orange.casa.codigo.repository.CategoriaRepository;
import com.orange.casa.codigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<LivroDto> listaLivros() {

		List<Livro> livros = livroRepository.findAll();

		return LivroDto.converterDto(livros);
	}

	@GetMapping("/{id}")
	public DetalheLivroDto detalhesLivro(@PathVariable Long id) {

		Livro livroBuscado = livroRepository.getOne(id);

		return new DetalheLivroDto(livroBuscado);
	}

	@PostMapping
	public String criarLivro(@RequestBody @Valid LivroForm livroForm) {

		Livro livro = livroForm.converteLivro(autorRepository, categoriaRepository);
		livroRepository.save(livro);

		return "Livro cadastrado";
	}

}
