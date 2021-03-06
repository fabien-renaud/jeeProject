package fr.epsi.jeeProject.beans;

import java.sql.Date;

public class Utilisateur {

	private String email;
	private String nom;
	private String passord;
	private Date dateCreation;
	private Boolean admin;
	
	public Utilisateur() {
		this.email = null;
		this.nom = null;
		this.passord = null;
		this.dateCreation = null;
		this.admin = null;
	}	
	
	public Utilisateur(String email, String nom, String passord, Date dateCreation, Boolean admin) {
		super();
		this.email = email;
		this.nom = nom;
		this.passord = passord;
		this.dateCreation = dateCreation;
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
}
