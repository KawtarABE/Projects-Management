package com.JAVA.DAO;

import java.util.List;
import com.JAVA.Beans.Prof;

public interface DAOProf {
	
	List<Prof> getAllprofesseurs(String id);
	void addProf(String code, String nom, String prenom, String domaine, String departement, String admin);
	void deleteProf(String code);
}
