package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entities.Client;
import com.example.entities.Conseiller;

import jakarta.annotation.PostConstruct;

@Component
public class DBinit {

	private ProxyClientDAO daoClient;
	private ProxyConseillerDAO daoConseiller;

	
	
	public DBinit(ProxyClientDAO daoClient, ProxyConseillerDAO daoConseiller) {
		this.daoClient = daoClient;
		this.daoConseiller = daoConseiller;
	}



	@PostConstruct
	public void proxyDAO() {
		
		Client A = new Client("bob");
		Client B = new Client("bobby");
		
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
		
	}
}
