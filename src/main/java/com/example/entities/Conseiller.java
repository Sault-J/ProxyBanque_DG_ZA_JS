package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy = "conseiller",cascade= {CascadeType.ALL})
	private List<Client> clients = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Conseiller() {
		// TODO Auto-generated constructor stub
	}
	
	public Conseiller(String name) {
		nom = name;
	}
	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + "]";
	}
	
	public void ajouterClient(Client client) {
		if(clients.size() < 10) {
			this.clients.add(client);
		}
	}
	
	
}
