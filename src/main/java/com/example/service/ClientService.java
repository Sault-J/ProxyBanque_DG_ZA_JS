package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entities.Client;



public interface ClientService {
	
	

	List<Client> getAllClients();
	
	Client saveClient(Client client);
	
	Optional<Client> getClientById(Long id);
	
	void deleteClientById(Long id);
	
	Client updateClient(Client client);
	
	boolean isClientIdExists(Long id);
}
