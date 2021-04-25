package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Pais;
import com.orange.casa.codigo.form.PaisForm;
import com.orange.casa.codigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public String postMethodName(@RequestBody @Valid PaisForm paisForm) {

		Pais pais = new Pais(paisForm.getNome());
		paisRepository.save(pais);

		return paisForm.toString();
	}

}
