package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Client;
import com.example.entities.Conseiller;
import com.example.repository.ProxyClientDAO;

@Service
public class ClientServiceImpl implements ClientService {

	private ProxyClientDAO clientDAO;
	
	@Autowired
	public ClientServiceImpl(ProxyClientDAO clientDAO1) {
		clientDAO = clientDAO1;
	}
	
	
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientDAO.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return clientDAO.save(client);
	}

	@Override
	public Optional<Client> getClientById(Long id) {
		// TODO Auto-generated method stub
		return clientDAO.findById(id);
	}

	@Override
	public void deleteClientById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientIdExists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
