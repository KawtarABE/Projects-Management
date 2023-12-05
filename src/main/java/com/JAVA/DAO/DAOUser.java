package com.JAVA.DAO;

import java.util.List;

import com.JAVA.Beans.Admin;
import com.JAVA.Beans.Chart;
import com.JAVA.Beans.Prof;
import com.JAVA.Beans.Recent;
import com.JAVA.Beans.Student;

public interface DAOUser {
//	all users
	boolean authentification(String code, String password);
	String getUserStatus(String code);
	String getPassword(String code);
	void updatePassword(String code, String password);
	void updateUser(String code, String nom, String prenom, String email, String numero);
	void insertUser(String code, String nom, String prenom, String password, String status, String email, String numero);
	
//	etudiant
	Student getStudentInfo(String code);	
	void updateStudent(String nom, String prenom, String promo, String filiere, String code);
	

//	prof
	Prof getProfInfo(String code);
	List<String> getAll_years(String id_prof);
	List<String> getAll_semestres(String id_prof);
	void updateProf(String nom, String prenom, String domaine, String departement, String code);


	
//  admin
	Admin getAdminInfo(String code);
	void updateAdmin(String nom, String prenom, String departement, String code);
	int numberStudents(String admin);
	int numberProfesseurs(String admin);
	int numberProjects(String admin);
	int numberProjects_year(String admin);
	List<Chart> chart(String admin);
	String getDapartement(String admin);
	List<String> getAll_years_admin(String admin);

}
