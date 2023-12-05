package com.JAVA.Beans;

public class Projet {
	private int id_projet;
	private String intitule;
	private String description;
	private String encadrant;
    private String etu1;
    private String etu2;
	private String annee;
	private String semestre;
    private int id_affectation;
    private String status;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId_projet() {
		return id_projet;
	}
	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(String encadrant) {
		this.encadrant = encadrant;
	}
	public String getEtu1() {
		return etu1;
	}
	public void setEtu1(String etu1) {
		this.etu1 = etu1;
	}
	public String getEtu2() {
		return etu2;
	}
	public void setEtu2(String etu2) {
		this.etu2 = etu2;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public int getId_affectation() {
		return id_affectation;
	}
	public void setId_affectation(int id_affectation) {
		this.id_affectation = id_affectation;
	}

}
