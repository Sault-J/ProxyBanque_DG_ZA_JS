package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ClientDTO;
import com.example.entities.Client;
import com.example.entities.Conseiller;
import com.example.repository.ProxyClientDAO;
import com.example.repository.ProxyConseillerDAO;


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
		
		/*
		Client a = new Client();
		
		a.setId(clientDTO.getId());
		a.setNom(clientDTO.getNom());
		a.setPrenom(clientDTO.getPrenom());
		a.setAdresse(clientDTO.getAdresse());
		a.setCodePostal(clientDTO.getCodePostal());
		a.setVille(clientDTO.getVille());
		a.setTel(clientDTO.getTel());
				
		Long id = clientDTO.getConseiller_id();
		Optional<Conseiller> conseiller = conseillerDAO.findById(id);
		a.setConseiller(conseiller.orElse(null));
		*/
		
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
		clientDAO.deleteById(id);
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		Long id = client.getId();
		return (clientDAO.existsById(id)) ? (clientDAO.save(client)) : (clientDAO.save(client));
	}

	@Override
	public boolean isClientIdExists(Long id) {
		// TODO Auto-generated method stub
		return clientDAO.existsById(id);
	}
	
	

}
