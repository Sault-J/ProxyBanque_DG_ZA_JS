package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Client;
import com.example.entities.Conseiller;
import com.example.repository.ProxyClientDAO;
import com.example.service.ClientService;
import com.example.service.ConseillerService;



@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
		
	}

	
	@GetMapping()
	Iterable<Client> getClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping("/{id}")
	Optional<Client> getClientById(@PathVariable Long id) {
		return clientService.getClientById(id);
	}

	@PostMapping()
	Client postClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	/*
	@PostMapping()
	Client ajouterClient(@RequestBody Client client) {
		Conseiller conseiller = conseillerService.getConseillerById(client.getConseiller().getId());
		client.setConseiller(conseiller);
		return clientService.saveClient(client);
		
	}

	*/

	

	
/*
	@DeleteMapping("/{id}")
	void deleteClient(@PathVariable Long id) {
		service.deleteCoffeeById(id);
	}

	

	

	@PutMapping("/{id}")
	ResponseEntity<Client> putClient(@PathVariable Long id, @RequestBody Client client){
			
			return (dao.isCoffeeIdExists(id)) ? 
					new ResponseEntity<>(service.saveCoffee(coffee), HttpStatus.OK) :
					new ResponseEntity<>(service.saveCoffee(coffee), HttpStatus.CREATED);
	}
		
					
*/
	
	
}
