package com.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String Tel;
	
	//@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="conseiller_id")
	private Conseiller conseiller;
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	@JoinColumn(name="compte_courant_id")
	private CompteCourant compteCourant;
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	@JoinColumn(name="compte_epargne_id")
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
	public void setVille(String ville1) {
		ville = ville1;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	
	
	
	
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String name,CompteCourant compteCourant1,CompteEpargne compteEpargne1) {
		nom = name;
		this.compteCourant = compteCourant1;
		if (compteCourant != null) {
			compteCourant.setClient(this);
		}	
		this.compteEpargne = compteEpargne1;
		if (compteEpargne != null) {
			compteEpargne.setClient(this);
		}

	}
	
	
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	

	@Override
	public String toString() {
		return "Client [Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", Tel=" + Tel + "]";
	}
	
	
}
