package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Conseiller;
import com.example.repository.ProxyConseillerDAO;

@Service
public class ConseillerServiceImpl implements ConseillerService {

	

private ProxyConseillerDAO conseillerDAO;
	
	@Autowired
	public ConseillerServiceImpl(ProxyConseillerDAO conseillerDAO1) {
		conseillerDAO = conseillerDAO1;
	}


	@Override
	public List<Conseiller> getAllConseillers() {
		// TODO Auto-generated method stub
		return conseillerDAO.findAll();
	}

	@Override
	public Conseiller saveConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return conseillerDAO.save(conseiller);
	}

	@Override
	public Optional<Conseiller> getConseillerById(Long id) {
		// TODO Auto-generated method stub
		return conseillerDAO.findById(id);
	}

	@Override
	public void deleteConseillerById(Long id) {
		// TODO Auto-generated method stub
		conseillerDAO.deleteById(id);
	}

	@Override
	public Conseiller updateConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		Long id = conseiller.getId();
		return (conseillerDAO.existsById(id)) ? (conseillerDAO.save(conseiller)) : (conseillerDAO.save(conseiller));
	}

	@Override
	public boolean isConseillerIdExists(Long id) {
		// TODO Auto-generated method stub
		return conseillerDAO.existsById(id);
	}
	
	

	

}
