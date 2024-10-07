package com.keepcoding.api.service;

import java.util.List;

import com.keepcoding.api.entity.Client;

public interface ClientService {
	
	// método para listar clientes
	public List<Client> ListClients();
	
	// método para buscar un cliente por id
	public Client clientById(Long id);
	
	// método para guardar un cliente
	public Client saveClient(Client client);
	
	// método para borrar un cliente por id
	public void deleteClientById(Long id);
	
	// método para buscar por nombre y apellido
	public Client findByNameAndSurname(String name, String surname);
	
	// método para buscar por email y teléfono.
	public Client findByEmailAndPhone(String email, int phone);
	
	// método para buscar por nombre
	public Client findByName(String name);

}
