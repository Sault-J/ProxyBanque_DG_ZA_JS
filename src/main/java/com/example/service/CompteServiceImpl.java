package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Compte;
import com.example.repository.ProxyClientDAO;
import com.example.repository.ProxyCompteDAO;

@Service
public class CompteServiceImpl implements CompteService {

private ProxyCompteDAO CompteDAO;
	
	
	
	@Autowired
	public CompteServiceImpl(ProxyCompteDAO CompteDAO1) {
		CompteDAO = CompteDAO1;
		
	}
	
	
	
	@Override
	public List<Compte> getAllComptes() {
		// TODO Auto-generated method stub
		return CompteDAO.findAll();
	}

	@Override
	public Compte saveCompte(Compte compte) {
		// TODO Auto-generated method stub
		return CompteDAO.save(compte);
	}

	@Override
	public Optional<Compte> getCompteById(Long id) {
		// TODO Auto-generated method stub
		return CompteDAO.findById(id);
	}

	@Override
	public void deleteCompteById(Long id) {
		// TODO Auto-generated method stub
		CompteDAO.deleteById(id);
	}

	@Override
	public Compte updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		Long id = compte.getId();
		return (CompteDAO.existsById(id)) ? (CompteDAO.save(compte)) : (CompteDAO.save(compte));
	}

	@Override
	public boolean isCompteIdExists(Long id) {
		// TODO Auto-generated method stub
		return CompteDAO.existsById(id);
	}

}
