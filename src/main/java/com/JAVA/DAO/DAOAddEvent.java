package com.JAVA.DAO;

import java.util.Date;
import java.util.List;

public interface DAOAddEvent {

	List<String> getIdetudiant(int id_affectation);
	int getIdprojet(int id_affectation);
	void insertEvent(String id_user, String title, String type, String detail, String date, String time, int id_projet);
}
