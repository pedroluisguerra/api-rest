package com.keepcoding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.api.entity.Client;
import com.keepcoding.api.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> index(){
		return clientService.ListClients();
	}
	
	@GetMapping("/clients/{id}")
	public Client show(@PathVariable Long id) {
		return clientService.clientById(id);
	}
	
	@GetMapping("/clients/name/{name}/surname/{surname}")
	public Client findByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
		return clientService.findByNameAndSurname(name, surname);
	}
	
	@GetMapping("/clients/email/{email}/phone/{phone}")
	public Client findByEmailAndPhone(@PathVariable String email, @PathVariable int phone) {
		return clientService.findByEmailAndPhone(email, phone);
	}
	
	@GetMapping("/clients/name/{name}")
	public Client findByName(@PathVariable String name) {
		return clientService.findByName(name);
	}

}
