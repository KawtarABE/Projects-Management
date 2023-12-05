package com.JAVA.DAO;

import java.util.List;

import com.JAVA.Beans.Student;

public interface DAOEtudiant {
	
	List<String> getAllpromos(String code);
	List<Student> getAlletudiants(String promo,String admin);
	void addEtudiant(String code, String nom, String prenom, String promo, String password, String filiere, String admin);
	void deleteEtudiant(String code);

}
