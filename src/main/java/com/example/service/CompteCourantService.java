package com.example.service;

import java.util.Optional;

import com.example.entities.CompteCourant;

public interface CompteCourantService {

	CompteCourant saveCompteCourant(CompteCourant compte);
	
	Optional<CompteCourant> getCompteCourantById(Long id);
	
	boolean isCompteCourantIdExists(Long id);
	
}
