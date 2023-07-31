package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.CompteCourant;
import com.example.repository.ProxyCompteCourantDAO;

@Service
public class CompteCourantServiceImpl implements CompteCourantService {

private ProxyCompteCourantDAO compteCourantDAO;
	
	
	
	@Autowired
	public CompteCourantServiceImpl(ProxyCompteCourantDAO compteCourantDAO1) {
		compteCourantDAO = compteCourantDAO1;
		
	}

	@Override
	public CompteCourant saveCompteCourant(CompteCourant compte) {
		// TODO Auto-generated method stub
		return compteCourantDAO.save(compte);
	}

	@Override
	public Optional<CompteCourant> getCompteCourantById(Long id) {
		// TODO Auto-generated method stub
		return compteCourantDAO.findById(id);
	}

	@Override
	public boolean isCompteCourantIdExists(Long id) {
		// TODO Auto-generated method stub
		return compteCourantDAO.existsById(id);
	}

}
