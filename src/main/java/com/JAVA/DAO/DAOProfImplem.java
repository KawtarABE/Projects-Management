package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JAVA.Beans.Prof;

public class DAOProfImplem implements DAOProf {
	
	private DAOFactory daoFactory;

    public DAOProfImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    public static Prof map(ResultSet resultat) throws SQLException {
    	Prof professeur = new Prof();
    	professeur.setCode(resultat.getString("code"));
    	professeur.setNom(resultat.getString("nom"));
    	professeur.setPrenom(resultat.getString("prenom"));
    	professeur.setDomaine(resultat.getString("domaine"));	
    	professeur.setEmail(resultat.getString("email"));
    	professeur.setNumero(resultat.getString("numero"));  	
    	return professeur;  	
    }

	
	public List<Prof> getAllprofesseurs(String id) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<Prof> list = new ArrayList<Prof>();
		Prof professeur;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM professeur join users on users.id=professeur.code  where admin=?");
			statement.setString(1, id);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				professeur = map(resultat);
				list.add(professeur);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void addProf(String code, String nom, String prenom, String domaine, String departement, String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
        
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into professeur(code,nom,prenom,domaine,departement,admin) values(?,?,?,?,?,?) ");
			statement.setString(1, code);
			statement.setString(2, nom);
			statement.setString(3, prenom);
			statement.setString(4, domaine);
			statement.setString(5,departement);
			statement.setString(6,admin);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProf(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
        
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update professeur set admin=? where code=?");
			statement.setString(1, null);
			statement.setString(2, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
