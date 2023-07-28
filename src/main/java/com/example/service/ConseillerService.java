package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entities.Conseiller;



public interface ConseillerService {
	
	

	List<Conseiller> getAllConseillers();
	
	Conseiller saveConseiller(Conseiller conseiller);
	
	Optional<Conseiller> getConseillerById(Long id);
	
	void deleteConseillerById(Long id);
	
	Conseiller updateConseiller(Conseiller conseiller);
	
	boolean isConseillerIdExists(Long id);
}
