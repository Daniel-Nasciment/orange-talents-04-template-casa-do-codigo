package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Aluno.Categoria;
import com.orange.casa.codigo.form.CategoriaForm;
import com.orange.casa.codigo.repository.CategoriaRepository;
import com.orange.casa.codigo.validator.ProibeNomeDuplicadoValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProibeNomeDuplicadoValidator proibeNomeDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoValidator);
	}

	
	@PostMapping
	public String criaCategoria(@RequestBody @Valid CategoriaForm categoriaForm) {
		
		Categoria categoria = new Categoria(categoriaForm.getNome());
		categoriaRepository.save(categoria);
		
		return categoriaForm.toString();
	}

	
}
