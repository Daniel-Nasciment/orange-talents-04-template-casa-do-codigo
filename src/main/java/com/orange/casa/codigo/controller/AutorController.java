package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Autor;
import com.orange.casa.codigo.form.AutorForm;
import com.orange.casa.codigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public String criaAutor(@RequestBody @Valid AutorForm autorForm) {

		Autor autor = autorForm.converteAutor();
		autorRepository.save(autor);

		return autorForm.toString();
	}

}
