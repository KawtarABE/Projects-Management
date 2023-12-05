package com.JAVA.DAO;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JAVA.Beans.Student;
import com.JAVA.Beans.Binome;

public class DAOBinomeImplem implements DAOBinomes{

	private DAOFactory daoFactory;

    public DAOBinomeImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public static Student map_student(ResultSet resultat) throws SQLException {
    	Student student = new Student();
    	student.setId(resultat.getString("code"));
    	student.setNom(resultat.getString("nom"));
    	student.setPrenom(resultat.getString("prenom"));
    	return student;  	
    }
	
	public static Binome map_binome(int id, Student student_1, Student student_2) throws SQLException {
    	Binome binome = new Binome();
    	binome.setId(id);
    	binome.setStudent1(student_1);
    	binome.setStudent2(student_2);
    	return binome;  	
    }
	
	@Override 
	public Student getStudent(String id_etudiant) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		Student student = new Student();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM etudiant WHERE code=?");
			statement.setString(1, id_etudiant);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				student = map_student(resultat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public List<Binome> getAllBinomes(String annee, String semestre, String id_encadrant) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_etudiant;
		String id_etudiant1;
		Student student = new Student();
		Student student1 = new Student();
		Binome binome = new Binome();
		int id_affectation;
		List<Binome> list = new ArrayList<Binome>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM affectation WHERE annee=? and semestre=? and id_encadrant=?");
			statement.setString(1, annee);
			statement.setString(2, semestre);
			statement.setString(3, id_encadrant);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				id_affectation = resultat.getInt("id_affectation");
				id_etudiant = resultat.getString("id_etudiant");
				id_etudiant1 = resultat.getString("id_etudiant1");
				student = getStudent(id_etudiant);
				student1 = getStudent(id_etudiant1);
				binome = map_binome(id_affectation,student,student1);
				list.add(binome);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	 }
	
	public List<Binome> getAllBinomes_prof(String id_encadrant) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_etudiant;
		String id_etudiant1;
		Student student = new Student();
		Student student1 = new Student();
		Binome binome = new Binome();
		int id_affectation;
		List<Binome> list = new ArrayList<Binome>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM affectation WHERE annee=extract(year from current_date) and id_encadrant=?");
			statement.setString(1, id_encadrant);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				id_affectation = resultat.getInt("id_affectation");
				id_etudiant = resultat.getString("id_etudiant");
				id_etudiant1 = resultat.getString("id_etudiant1");
				student = getStudent(id_etudiant);
				student1 = getStudent(id_etudiant1);
				binome = map_binome(id_affectation,student,student1);
				list.add(binome);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	 }
	
	public List<String> getIds(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_etudiant;
		String id_etudiant1;
		List<String> list = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT id_etudiant, id_etudiant1 FROM affectation WHERE id_affectation=?");
			statement.setInt(1, id_affectation);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				id_etudiant = resultat.getString("id_etudiant");
				id_etudiant1 = resultat.getString("id_etudiant1");
				list.add(id_etudiant);
				list.add(id_etudiant1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;		
	}
	
	public List<String> getIds_semestre(String semestre, String id_encadrant) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_etudiant = null;
		List<String> list = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(id_etudiant) from affectation where semestre=? and annee=extract(year from current_date) and id_encadrant=? union select distinct(id_etudiant1) from affectation where semestre=? and annee=extract(year from current_date) and id_encadrant=?");
			statement.setString(1, semestre);
			statement.setString(2, id_encadrant);
			statement.setString(3, semestre);
			statement.setString(4, id_encadrant);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				id_etudiant = resultat.getString("id_etudiant");
				list.add(id_etudiant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;		
	}
	
	
}

    
   
