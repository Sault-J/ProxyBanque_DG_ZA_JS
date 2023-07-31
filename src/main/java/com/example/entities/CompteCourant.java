package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class CompteCourant extends Compte {

	private Long decouvert = 1000L;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Client client;

	public Long getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Long decouvert) {
		this.decouvert = decouvert;
	}
	
	public CompteCourant() {
		this.client=new Client();
		this.client.setCompteCourant(this);
	}

	public CompteCourant(Long decouvert) {
		this.decouvert = decouvert;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
