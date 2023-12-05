package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

	private DAOFactory daoFactory;

    public Connexion( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	public boolean getConnexion() throws DAOException {
		Connection connexion = null;
		boolean connex = false ;
		try {
			connexion = daoFactory.getConnection();
			if(connexion == null){ 
				connex = false;
			} else {
				connex = true;
			}
				
	   }
       catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connex;
	}
	
	public String getResult(int id) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String msg = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT title FROM events where id=?");
			statement.setInt(1,id);
		    resultat = statement.executeQuery();
		    if(resultat.next()) {
		    	msg = resultat.getString("title");
		    }
		    else {
		    	msg = null;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
		
	}
}
