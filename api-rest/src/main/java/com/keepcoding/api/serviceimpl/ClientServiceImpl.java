package com.keepcoding.api.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.keepcoding.api.entity.Client;
import com.keepcoding.api.repository.ClientRepository;
import com.keepcoding.api.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Client> ListClients() {
		
		return (List<Client>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Client clientById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client saveClient(Client client) {
		
		return repository.save(client);
	}

	@Override
	@Transactional
	public void deleteClientById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Client findByNameAndSurname(String name, String surname) {
		
		return repository.findByNameAndSurname(name, surname);
	}

	@Override
	@Transactional(readOnly = true)
	public Client findByEmailAndPhone(String email, int phone) {
		
		return repository.findByEmailAndPhone(email, phone);
		
	}
		
	@Override
	@Transactional(readOnly = true)
	public Client findByName(String name) {
			
		return repository.findByName(name);
		
	}	

}
