package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ClientDTO;
import com.example.entities.Client;
import com.example.repository.ProxyClientDAO;
import com.example.repository.ProxyConseillerDAO;


@Service
public class ClientServiceImpl implements ClientService {

	private ProxyClientDAO clientDAO;
	private ProxyConseillerDAO conseillerDAO;
	
	
	
	@Autowired
	public ClientServiceImpl(ProxyClientDAO clientDAO1, ProxyConseillerDAO conseillerDAO1) {
		clientDAO = clientDAO1;
		conseillerDAO = conseillerDAO1;
	}
	
	
	@Override
	public List<ClientDTO> getAllClients() {
		// TODO Auto-generated method stub
		
		List<Client> clients = clientDAO.findAll();
		
		List<ClientDTO> clientsDTOs = new ArrayList<>();
		
		clients.forEach(client -> {
					ClientDTO dto = this.ClientToDTO(client);
					clientsDTOs.add(dto);
		});
				
		return clientsDTOs;
	}

	@Override
	public ResponseEntity<ClientDTO> saveClient(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		
		
		Client a = this.DTOToClient(clientDTO);
		
		clientDAO.save(a);
		return ResponseEntity.ok(clientDTO);
	}

	@Override
	public Optional<ClientDTO> getClientById(Long id) {
		// TODO Auto-generated method stub
		
		Client a = clientDAO.findById(id).orElse(null);
		
		ClientDTO b = this.ClientToDTO(a);
		
		
		
		return Optional.of(b);
	}

	@Override
	public void deleteClientById(Long id) {
		// TODO Auto-generated method stub
		clientDAO.deleteById(id);
	}

//	@Override
//	public Client updateClient(Client client) {
//		// TODO Auto-generated method stub
//		Long id = client.getId();
//		return (clientDAO.existsById(id)) ? (clientDAO.save(client)) : (clientDAO.save(client));
//	}

	@Override
	public boolean isClientIdExists(Long id) {
		// TODO Auto-generated method stub
		return clientDAO.existsById(id);
	}


	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	
//
	Client DTOToClient(ClientDTO clientDTO) {
		
		Client a = new Client();
		
		
		a.setNom(clientDTO.getNom());
		a.setPrenom(clientDTO.getPrenom());
		a.setAdresse(clientDTO.getAdresse());
		a.setCodePostal(clientDTO.getCodePostal());
		a.setVille(clientDTO.getVille());
		a.setTel(clientDTO.getTel());
		
				
		a.setConseiller(conseillerDAO.findById(clientDTO.getConseiller_id()).get());
		return a;
		
	}
	
	ClientDTO ClientToDTO(Client client) {
		
		ClientDTO a = new ClientDTO();
		
		a.setId(client.getId());
		a.setNom(client.getNom());
		a.setPrenom(client.getPrenom());
		a.setAdresse(client.getAdresse());
		a.setCodePostal(client.getCodePostal());
		a.setVille(client.getVille());
		a.setTel(client.getTel());
		a.setCompteCourant(client.getCompteCourant());
		a.setCompteEpargne(client.getCompteEpargne());
				
		a.setConseiller_id(client.getConseiller().getId());
		return a;

		
	}


	public ProxyClientDAO getClientDAO() {
		return clientDAO;
	}


	public void setClientDAO(ProxyClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}


	public ProxyConseillerDAO getConseillerDAO() {
		return conseillerDAO;
	}


	public void setConseillerDAO(ProxyConseillerDAO conseillerDAO) {
		this.conseillerDAO = conseillerDAO;
	}
	
	

}
