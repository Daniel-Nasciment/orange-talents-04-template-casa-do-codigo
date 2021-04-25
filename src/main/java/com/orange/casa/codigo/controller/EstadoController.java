package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Estado;
import com.orange.casa.codigo.form.EstadoForm;
import com.orange.casa.codigo.repository.EstadoRepository;
import com.orange.casa.codigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public String criaEstado(@RequestBody @Valid EstadoForm estadoForm) {

		Estado estado = estadoForm.ConverteEstado(paisRepository);

		estadoRepository.save(estado);

		return "Estado criado";
	}

}
