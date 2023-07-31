package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entities.Client;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;
import com.example.entities.Conseiller;

import jakarta.annotation.PostConstruct;

@Component
public class DBinit {

	private ProxyClientDAO daoClient;
	private ProxyConseillerDAO daoConseiller;
	private ProxyCompteDAO daoCompte;

	
	
	public DBinit(ProxyClientDAO daoClient, ProxyConseillerDAO daoConseiller, ProxyCompteDAO daoCompte) {
		this.daoClient = daoClient;
		this.daoConseiller = daoConseiller;
		this.daoCompte = daoCompte;
	}



	@PostConstruct
	public void proxyDAO() {
		
		CompteCourant C1 = new CompteCourant();
		CompteCourant C2 = new CompteCourant();
		CompteEpargne C3 = new CompteEpargne();
		CompteEpargne C4 = new CompteEpargne();
		
		
		
		
		Client A = new Client("bob",C1,C3);
		Client B = new Client("bobby",C2,C4);
		
		
		
		Conseiller C = new Conseiller("Victor");
		
		
		
		A.setConseiller(C);
		B.setConseiller(C);
		
		
		C.getClients().add(A);
		C.getClients().add(B);
		
		daoClient.saveAll(List.of(
				A,
				B
				
				));
		
		daoConseiller.saveAll(List.of(C));
		
		daoCompte.saveAll(List.of(C1,C2,C3,C4));

		
	}
}
