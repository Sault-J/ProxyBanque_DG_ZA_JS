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

import com.example.entities.Compte;
import com.example.service.CompteService;

@RestController
@RequestMapping("/comptes")
public class CompteController {
	
	private CompteService compteService;
	
	
	@Autowired
	public CompteController(CompteService compteService) {
		this.compteService = compteService;
		
	}

	
	@GetMapping()
	Iterable<Compte> getComptes() {
		return compteService.getAllComptes();
	}
	
	@GetMapping("/{id}")
	Optional<Compte> getCompteById(@PathVariable Long id) {
		return compteService.getCompteById(id);
	}

	@PostMapping()
	Compte postCompte(@RequestBody Compte compte) {
		
		return compteService.saveCompte(compte);
	}
	
	

	@DeleteMapping("/{id}")
	void deleteCompte(@PathVariable Long id) {
		compteService.deleteCompteById(id);
	}

	

	

	@PutMapping("/{id}")
	ResponseEntity<Compte> putCompte(@PathVariable Long id, @RequestBody Compte compte){
			
			return (compteService.isCompteIdExists(id)) ? 
					new ResponseEntity<>(compteService.saveCompte(compte), HttpStatus.OK) :
					new ResponseEntity<>(compteService.saveCompte(compte), HttpStatus.CREATED);
	}
	
	
}
