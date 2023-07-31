package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.service.CompteCourantService;

@RestController
@RequestMapping("/Virement")
public class CompteCourantController {
	
	private CompteCourantService compteCourantService;
	
	
	@Autowired
	public CompteCourantController(CompteCourantService compteCourantService) {
		this.compteCourantService = compteCourantService;
		
	}
	

	
	@PutMapping("/{id1},{id2},{solde}")
	List<Compte> Versement(@PathVariable Long id1, @PathVariable Long id2, @PathVariable int solde){
		
		CompteCourant C1 = compteCourantService.getCompteCourantById(id1).get();
		CompteCourant C2 = compteCourantService.getCompteCourantById(id2).get();
		
		int solde1 = C1.getSolde();
		int solde2 = C2.getSolde();
		
		C1.setSolde(solde1 - solde);
		C2.setSolde(solde2 + solde);
		
		compteCourantService.saveCompteCourant(C1);
		compteCourantService.saveCompteCourant(C2);
		
		List<Compte> comptes = new ArrayList<>();
		comptes.add(C1);
		comptes.add(C2);
		return comptes;
	}
	
}
