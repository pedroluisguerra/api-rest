package com.keepcoding.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.api.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
		
	Client findByNameAndSurname(String name, String surname);
	
	Client findByEmailAndPhone(String email, int phone);
	
	@Query("select n from Client n where n.name = ?1")
	Client findByName(String name);
}
