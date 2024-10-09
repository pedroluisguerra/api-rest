package com.keepcoding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.api.entity.Client;
import com.keepcoding.api.service.ClientService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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
	
	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public Client clientSave(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@PutMapping("/clients/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Client clientUpdate(@PathVariable Long id, @RequestBody Client client) {
		
		// Recuperamso el registro del cliente que queremos modificar.
		Client clientUpdateRequest = clientService.clientById(id);
		
		// Cargar los nuevos datos del cliente desde el "cliente" recibido.
		clientUpdateRequest.setName(client.getName());
		clientUpdateRequest.setSurname(client.getSurname());
		clientUpdateRequest.setEmail(client.getEmail());
		clientUpdateRequest.setPhone(client.getPhone());		
		
		return clientService.saveClient(clientUpdateRequest);
	}
	
	@DeleteMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteClientById(id);
	}
	

}
