package com.JAVA.Beans;

import java.io.InputStream;

public class Phase {
	private int id;
	private String phase;
	private int id_projet;
	private String pourcentage;
	private String description;
	private String detail_etudiant;
	private String detail_prof;
	private String file_name;
	private InputStream file_data;
	
	public String getDescription() {
		return description;
	}
	public String getDetail_etudiant() {
		return detail_etudiant;
	}
	public void setDetail_etudiant(String detail_etudiant) {
		this.detail_etudiant = detail_etudiant;
	}
	public String getDetail_prof() {
		return detail_prof;
	}
	public void setDetail_prof(String detail_prof) {
		this.detail_prof = detail_prof;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public InputStream getFile_data() {
		return file_data;
	}
	public void setFile_data(InputStream file_data) {
		this.file_data = file_data;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public String getPourcentage() {
		return pourcentage;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setPourcentage(String pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String getPhase() {
		return phase;
	}
	public int getId_projet() {
		return id_projet;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

}
