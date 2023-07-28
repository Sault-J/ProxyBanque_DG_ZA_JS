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
@RequestMapping("/conseillers")
public class ConseillerController {
	
	
	private ConseillerService conseillerService;
	
	@Autowired
	public ConseillerController(ConseillerService conseillerService) {
		
		this.conseillerService = conseillerService;
	}

	
	@GetMapping()
	Iterable<Conseiller> getConseillers() {
		return conseillerService.getAllConseillers();
	}
	
	@GetMapping("/{id}")
	Optional<Conseiller> getClientById(@PathVariable Long id) {
		return conseillerService.getConseillerById(id);
	}

	@PostMapping()
	Conseiller postClient(@RequestBody Conseiller conseiller) {
		return conseillerService.saveConseiller(conseiller);
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
