package com.example.dto;

import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;

import jakarta.validation.constraints.NotEmpty;

public class ClientDTO {
	
//Inutile -> L'id fournit au DTO ne sera pas donné au client (@GeneratedValue)
	private Long Id;
//
	
	@NotEmpty(message = "Client name field can't be empty")
	private String nom;
	
	@NotEmpty(message = "Client surname field can't be empty")
	private String prenom;
	
	private String adresse;
	private String codePostal;
	private String ville;
	private String Tel;
	private Long conseiller_id;
	
	private CompteCourant compteCourant;
	
	
	private CompteEpargne compteEpargne;

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public Long getConseiller_id() {
		return conseiller_id;
	}
	public void setConseiller_id(Long conseiller_id) {
		this.conseiller_id = conseiller_id;
	}
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	
	

}
