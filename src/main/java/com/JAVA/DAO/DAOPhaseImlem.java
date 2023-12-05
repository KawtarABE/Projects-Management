package com.JAVA.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;


import com.JAVA.Beans.Phase;
import com.JAVA.Beans.Recent;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPhaseImlem implements DAOPhase{
	
	private DAOFactory daoFactory;

    public DAOPhaseImlem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public static Phase map(ResultSet resultat) throws SQLException {
    	Phase phase = new Phase();
    	phase.setId(resultat.getInt("id"));
    	phase.setId_projet(resultat.getInt("id_projet"));
    	phase.setPhase(resultat.getString("phase"));
    	phase.setPourcentage(resultat.getString("pourcentage")); 	
    	phase.setDescription(resultat.getString("description"));	
    	return phase;	
    }
	
	public static Recent maping(ResultSet resultat) throws SQLException {
    	Recent recent = new Recent();
    	recent.setIntitule(resultat.getString("intitule"));
    	recent.setPhase(resultat.getString("phase"));
    	recent.setPourcentage(resultat.getString("pourcentage")); 			
    	return recent;	
    }
	
	public static Phase map1(int id, int id_projet, String phase1, String pourcentage, String description, String detail_etudiant, String detail_prof, String file_name, InputStream file_data) throws SQLException {
    	Phase phase = new Phase();
    	phase.setId(id);
    	phase.setId_projet(id_projet);
    	phase.setPhase(phase1);
    	phase.setPourcentage(pourcentage); 	
    	phase.setDescription(description);	
    	phase.setDetail_etudiant(detail_etudiant);
    	phase.setDetail_prof(detail_prof);
    	phase.setFile_name(file_name);
    	phase.setFile_data(file_data);
    	return phase;	
    }
	
	public List<Phase> getAllphases(int id_projet) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		Phase phase;
		List<Phase> list = new ArrayList<Phase>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select * from phase where id_projet=?");
			statement.setInt(1,id_projet);
			resultat = statement.executeQuery();   
			while(resultat.next()) {	
				phase = map(resultat);
				list.add(phase);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return list;
	}
	
	public Phase getPhase(int id_projet, int id_phase) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int id;
		int id_projet1;
		String phase1;
		String pourcentage;
		String description;
		String detail_etudiant;
		String detail_prof;
		String file_name;
		InputStream file_data;
		Phase phase = new Phase();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select * from phase where id_projet=? and id=?");
			statement.setInt(1,id_projet);
			statement.setInt(2,id_phase);
			resultat = statement.executeQuery();   
			while(resultat.next()) {
				id = resultat.getInt("id");
				id_projet1 = resultat.getInt("id_projet");
				phase1 = resultat.getString("phase");
				pourcentage = resultat.getString("pourcentage");
				description = resultat.getString("description");
				detail_etudiant = resultat.getString("detail_etudiant");
				detail_prof = resultat.getString("detail_prof");
				file_name = resultat.getString("file_name");
				file_data = resultat.getBinaryStream("file_data");
				phase = map1(id,id_projet1,phase1,pourcentage,description,detail_etudiant,detail_prof,file_name,file_data);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return phase;		
	}
    
	public void modifyPhase(int id, String pourcentage, String detail_etudiant, String file_name, InputStream file_data) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update phase set pourcentage=?, detail_etudiant=?, file_name=?, file_data=? where id=?");
			statement.setString(1,pourcentage);
			statement.setString(2,detail_etudiant);
			statement.setString(3,file_name);
			statement.setBlob(4,file_data);
			statement.setInt(5,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyPhase_prof(int id, String detail_prof) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update phase set detail_prof=? where id=?");
			statement.setString(1,detail_prof);
			statement.setInt(2,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPhase(int id_projet, String phase, String description) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into phase(phase,description,id_projet) values(?,?,?)");
			statement.setString(1,phase);
			statement.setString(2,description);
			statement.setInt(3, id_projet);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public int incompletePhases(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count from (select nom, phase, pourcentage from phase ph join projet p join affectation a join etudiant e on ph.id_projet = p.id_projet and p.id_affectation = a.id_affectation and a.id_etudiant = e.code where e.code=? union select nom, phase, pourcentage from phase ph join projet p join affectation a join etudiant e on ph.id_projet = p.id_projet and p.id_affectation = a.id_affectation and a.id_etudiant1 = e.code where e.code=?) as count where pourcentage != ?");
			statement.setString(1, id_user);
			statement.setString(2, id_user);
			statement.setString(3, "100");
		    resultat = statement.executeQuery();
		    while(resultat.next()) {
		    	count = resultat.getInt("count");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
    }
    
    public List<Recent> getRecents(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		Recent recent = new Recent();
		List<Recent> list = new ArrayList<Recent>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select phase.id, projet.intitule, phase.phase, phase.pourcentage from phase join projet join affectation on phase.id_projet = projet.id_projet and projet.id_affectation = affectation.id_affectation where affectation.id_etudiant=? or affectation.id_etudiant1=? order by phase.id desc limit 5");
			statement.setString(1, id_user);
			statement.setString(2, id_user);
		    resultat = statement.executeQuery();
		    while(resultat.next()) {
		    	recent = maping(resultat);
		    	list.add(recent);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
    
    public List<Recent> getRecents_prof(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		Recent recent = new Recent();
		List<Recent> list = new ArrayList<Recent>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select phase.id, projet.intitule, phase.phase, phase.pourcentage from phase join projet join affectation on phase.id_projet = projet.id_projet and projet.id_affectation = affectation.id_affectation where affectation.id_encadrant=? order by phase.id desc limit 5");
			statement.setString(1, id_user);
		    resultat = statement.executeQuery();
		    while(resultat.next()) {
		    	recent = maping(resultat);
		    	list.add(recent);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
}
