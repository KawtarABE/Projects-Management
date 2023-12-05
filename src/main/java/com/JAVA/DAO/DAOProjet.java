package com.JAVA.DAO;


import java.util.List;
import com.JAVA.Beans.Projet;

public interface DAOProjet {
	List<Projet> getAllprojets(String code );
	List<Projet> getAllprojets_prof(String code, String annee, String semestre);
	
	int getIdProjet(int id_affectation);
	String getProf_description(int id_affectation);
	String getIntitule(int id_affectation);
	String getDescription(int id_affectation);
	String getStatus(int id_affectation);
	
	void addProjet(String intitule, String description, int id_affectation);
	void modifyProjet(String intitule, String description, int id_projet);
	void modifyProjet_prof(String description_prof, int id_projet);
	
	int numberProjects(String id_etudiant);
	int numberProjects_prof(String id_encadrant);
	int numberAffectations_prof(String id_user);
	
	int numberIndefinedProjects(String id_etudiant);
}
