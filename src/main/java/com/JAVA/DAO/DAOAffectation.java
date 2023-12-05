package com.JAVA.DAO;

import java.util.List;

import com.JAVA.Beans.Affectation;

public interface DAOAffectation {
	
	List<Affectation> getAllaffectation(String admin, String annee, String semestre);
	void addAffectation(String id_etudiant, String id_etudiant1, String id_encadrant, String annee, String semestre, String admin);
	void deleteAffectation(int id_affectation);
}
