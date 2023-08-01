package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.dto.ClientDTO;
import com.example.entities.Client;



public interface ClientService {
	

	List<ClientDTO> getAllClients();
	
	ResponseEntity<ClientDTO> saveClient(ClientDTO clientDTO);
	
	Optional<ClientDTO> getClientById(Long id);
	
	void deleteClientById(Long id);
	
	Client updateClient(Client client);
	
	boolean isClientIdExists(Long id);
	
	
}
