package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entities.Compte;

public interface CompteService {

	List<Compte> getAllComptes();
	
	Compte saveCompte(Compte compte);
	
	Optional<Compte> getCompteById(Long id);
	
	void deleteCompteById(Long id);
	
	Compte updateCompte(Compte compte);
	
	boolean isCompteIdExists(Long id);
}
