package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class CompteEpargne extends Compte {

	private float txInteret = 0.3F;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Client client;

	
	
	public CompteEpargne() {
		this.client=new Client();
		this.client.setCompteEpargne(this);
	}

	public CompteEpargne(float interet) {
		this.txInteret = interet;
	}
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getTxInteret() {
		return txInteret;
	}

	public void setTxInteret(float txInteret) {
		this.txInteret = txInteret;
	}
	
	
	
}