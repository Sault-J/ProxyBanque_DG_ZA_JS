package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Conseiller;
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
	Optional<Conseiller> getConseillerById(@PathVariable Long id) {
		return conseillerService.getConseillerById(id);
	}

	@PostMapping()
	Conseiller postConseiller(@RequestBody Conseiller conseiller) {
		return conseillerService.saveConseiller(conseiller);
	}
	
	
	

	

	

	@DeleteMapping("/{id}")
	void deleteConseiller(@PathVariable Long id) {
		conseillerService.deleteConseillerById(id);
	}

	

	

	@PutMapping("/{id}")
	ResponseEntity<Conseiller> putClient(@PathVariable Long id, @RequestBody Conseiller conseiller){
			
			return (conseillerService.isConseillerIdExists(id)) ? 
					new ResponseEntity<>(conseillerService.saveConseiller(conseiller), HttpStatus.OK) :
					new ResponseEntity<>(conseillerService.saveConseiller(conseiller), HttpStatus.CREATED);
	}
		
					

	
	
}
