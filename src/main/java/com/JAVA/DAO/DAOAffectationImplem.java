package com.JAVA.DAO;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JAVA.Beans.Student;
import com.JAVA.Beans.Affectation;
import com.JAVA.Beans.Binome;

public class DAOAffectationImplem implements DAOAffectation {

	private DAOFactory daoFactory;

    public DAOAffectationImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public static Affectation map(ResultSet resultat) throws SQLException {
    	Affectation affectation = new Affectation();
    	affectation.setId_affectation(resultat.getInt("id_affectation"));
    	affectation.setEtudiant1(resultat.getString("etudiant1"));
    	affectation.setEtudiant2(resultat.getString("etudiant2"));
    	affectation.setEncadrant(resultat.getString("encadrant"));
    	return affectation;  	
    }
	
	public List<Affectation> getAllaffectation(String admin, String annee, String semestre) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		Affectation affectation;
		List<Affectation> list = new ArrayList<Affectation>();
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement(" SELECT id_affectation, concat(e.nom,' ',e.prenom) as etudiant1 , concat(e1.nom,' ',e1.prenom) as etudiant2, concat(p.nom,' ',p.prenom) as encadrant  FROM affectation a JOIN etudiant e JOIN etudiant e1 JOIN professeur p on a.id_etudiant=e.code and a.id_etudiant1 = e1.code and a.id_encadrant=p.code where a.admin=? and annee=? and semestre=? order by id_affectation asc");
			statement.setString(1, admin);
			statement.setString(2, annee);
			statement.setString(3, semestre);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				affectation = map(resultat);
				list.add(affectation);
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return list;
	}
	
	public void addAffectation(String id_etudiant, String id_etudiant1, String id_encadrant, String annee, String semestre, String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into affectation(id_etudiant,id_etudiant1,id_encadrant,annee,semestre,admin) Values(?,?,?,?,?,?)");
			statement.setString(1, id_etudiant);
			statement.setString(2, id_etudiant1);
			statement.setString(3, id_encadrant);
			statement.setString(4, annee);
			statement.setString(5, semestre);
			statement.setString(6, admin);
			statement.executeUpdate();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public void deleteAffectation(int code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
        
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("delete from affectation where id_affectation=?");
			statement.setInt(1, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}