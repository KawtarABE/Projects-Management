package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JAVA.Beans.Student;

public class DAOEtudiantImplem implements DAOEtudiant {
	
	private DAOFactory daoFactory;

    public DAOEtudiantImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    public static Student map(ResultSet resultat) throws SQLException {
    	Student etudiant = new Student();
    	etudiant.setCode(resultat.getString("code"));
    	etudiant.setNom(resultat.getString("nom"));
    	etudiant.setPrenom(resultat.getString("prenom"));
    	etudiant.setFiliere(resultat.getString("filiere"));
    	etudiant.setEmail(resultat.getString("email"));
    	etudiant.setNumero(resultat.getString("numero"));
    	return etudiant;  	
    }

    
	public List<String> getAllpromos(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<String> list = new ArrayList<String>();
		String promo;
		try {
			connexion = daoFactory.getConnection();
			statement =connexion.prepareStatement("SELECT DISTINCT(promo) from etudiant where admin=? ORDER BY promo ASC");
			statement.setString(1, code);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				promo = resultat.getString("promo");
				list.add(promo);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
	
	public List<Student> getAlletudiants(String promo,String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<Student> list = new ArrayList<Student>();
		Student etudiant;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM etudiant join users on users.id = etudiant.code WHERE promo=? and admin=?");
			statement.setString(1,promo);
			statement.setString(2, admin);
			resultat = statement.executeQuery();	    
			while(resultat.next()) {
				etudiant = map(resultat);
				list.add(etudiant);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	public void addEtudiant(String code, String nom, String prenom, String promo, String password, String filiere, String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into etudiant values(?,?,?,?,?,?,?)");
			statement.setString(1,code);
			statement.setString(2,nom);
			statement.setString(3,prenom);
			statement.setString(4,promo);
			statement.setString(5,password);
			statement.setString(6,filiere);
			statement.setString(7,admin);
			statement.executeUpdate();	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteEtudiant(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
        
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update etudiant set admin=? where code=?");
			statement.setString(1, null);
			statement.setString(2, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
