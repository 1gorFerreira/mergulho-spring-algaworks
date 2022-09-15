package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	//Outra forma de injetar dependencia além do uso do @Autowired
	/*public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}*/

	@GetMapping("/clientes")
	public List<Cliente> listar(){
		return clienteRepository.findByNome("João");
	}

}
