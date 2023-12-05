package com.JAVA.DAO;
import java.util.List;
import com.JAVA.Beans.Binome;
import com.JAVA.Beans.Student;


public interface DAOBinomes {
    Student getStudent(String id_student);
	List<Binome> getAllBinomes(String annee, String semestre, String id_encadrant);
	List<Binome> getAllBinomes_prof(String id_encadrant);
	List<String> getIds(int id_affectation);
	List<String> getIds_semestre(String semestre, String id_encadrant);
}
