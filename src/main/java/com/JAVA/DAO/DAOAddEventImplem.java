package com.JAVA.DAO;

import java.sql.Connection;
import java.util.Date;
import java.util.List;


import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DAOAddEventImplem implements DAOAddEvent{
	private DAOFactory daoFactory;

    public DAOAddEventImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	@Override 
	public List<String> getIdetudiant(int id_affectation) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<String> id_users = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM affectation WHERE id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				String id_etudiant = resultat.getString("id_etudiant");
				String id_etudiant1 = resultat.getString("id_etudiant1");
				String id_encadrant = resultat.getString("id_encadrant");
				id_users.add(id_etudiant);
				id_users.add(id_etudiant1);
				id_users.add(id_encadrant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id_users;
	}

	@Override 
	public int getIdprojet(int id_affectation) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int id_projet = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM projet WHERE id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				id_projet = resultat.getInt("id_projet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return id_projet;
	}
	
	@Override 
	public void insertEvent(String id_user, String title, String type, String detail, String date, String time, int id_projet) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("INSERT INTO events(id_user, title, type, detail, date, heure, id_affectation) VALUES(?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, id_user);
			statement.setString(2, title);
			statement.setString(3, type);
			statement.setString(4, detail);
			statement.setString(5, date);
			statement.setString(6, time);
			statement.setInt(7, id_projet);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
