package com.JAVA.DAO;

import java.io.InputStream;
import java.util.List;

import com.JAVA.Beans.Phase;
import com.JAVA.Beans.Recent;

public interface DAOPhase {
//	getters
	List<Phase> getAllphases(int id_projet);
	Phase getPhase(int id_projet, int id_phase);
	int incompletePhases(String id_user);
	List<Recent> getRecents(String id_user);
	List<Recent> getRecents_prof(String id_user);
	
//	modify
	void modifyPhase(int id, String pourcentage, String detail_etudiant, String file_name, InputStream file_data);
	void modifyPhase_prof(int id, String detail_prof);
	
//	add
	void addPhase(int id_projet, String phase, String description);
}
