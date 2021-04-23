package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Livro;
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

	@PostMapping
	public String postMethodName(@RequestBody @Valid LivroForm livroForm) {
		
		Livro livro = livroForm.converteLivro(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		
		return "Livro cadastrado";
	}

}
