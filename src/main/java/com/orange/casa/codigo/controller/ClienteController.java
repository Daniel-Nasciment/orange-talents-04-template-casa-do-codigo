package com.orange.casa.codigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.casa.codigo.Modelo.Cliente;
import com.orange.casa.codigo.form.ClienteForm;
import com.orange.casa.codigo.repository.ClienteRepository;
import com.orange.casa.codigo.repository.EstadoRepository;
import com.orange.casa.codigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	public String criaCliente(@RequestBody @Valid ClienteForm clienteForm) {
		
		Cliente cliente = clienteForm.converteCliente(paisRepository, estadoRepository);
		
		clienteRepository.save(cliente);
		
		return cliente.toString();
	}

	
}
