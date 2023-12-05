package com.JAVA.DAO;

import com.JAVA.Beans.Projet;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOProjetImplem implements DAOProjet {

	private DAOFactory daoFactory;

    public DAOProjetImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    public static Projet map(int id_projet, String intitule, String description, String status, String encadrant, String binome, String annee, String semestre, int id_affectation) throws SQLException {
    	Projet projet = new Projet();
        projet.setId_projet(id_projet);
    	projet.setIntitule(intitule);
    	projet.setDescription(description);
    	projet.setStatus(status);
    	projet.setEncadrant(encadrant);
    	projet.setEtu2(binome);
    	projet.setAnnee(annee);
    	projet.setSemestre(semestre);
        projet.setId_affectation(id_affectation);
    	return projet;  	
    }
    
    public int getIdProjet(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		int id_projet = 0;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select id_projet from projet where id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				id_projet = resultat.getInt("id_projet");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return id_projet;    	
    }
    
    public String getIntitule(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		String intitule = null;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select intitule from projet where id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				intitule = resultat.getString("intitule");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return intitule;
    }
    
    public String getDescription(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		String intitule = null;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select description from projet where id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				intitule = resultat.getString("description");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return intitule;
    }
    
    public String getProf_description(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		String intitule = null;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select prof_comment from projet where id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				intitule = resultat.getString("prof_comment");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return intitule;
    }
    
    public String getStatus(int id_affectation) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null ;
		String intitule = null;
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select status from projet where id_affectation=?");
			statement.setInt(1, id_affectation);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				intitule = resultat.getString("status");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	return intitule;
    }
    
	public List<Projet> getAllprojets(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int id_projet;
		String intitule;
		String description;
		String status;
		String encadrant;
		String binome;
		String annee;
		String semestre;
		int id_affectation;	
		List<Projet> list = new ArrayList<Projet>();
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT a.annee, a.semestre, concat(e1.nom,' ',e1.prenom) as etu2 , concat(p.nom,' ',p.prenom) as encadrant , a.id_affectation FROM affectation a JOIN etudiant e JOIN etudiant e1 JOIN professeur p on a.id_etudiant=e.code and a.id_etudiant1 = e1.code and a.id_encadrant=p.code where a.id_etudiant=? UNION SELECT a.annee, a.semestre, concat(e1.nom,' ',e1.prenom) as etu2 , concat(p.nom,' ',p.prenom) as encadrant, a.id_affectation FROM affectation a JOIN etudiant e JOIN etudiant e1 JOIN professeur p on a.id_etudiant1=e.code and a.id_etudiant=e1.code and a.id_encadrant=p.code where a.id_etudiant1=? order by id_affectation desc");
			statement.setString(1, code);
			statement.setString(2, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				Projet projet = new Projet();
				id_affectation = resultat.getInt("id_affectation");
				id_projet = getIdProjet(id_affectation);
				intitule = getIntitule(id_affectation);
				description = getDescription(id_affectation);
				status = getStatus(id_affectation);
				encadrant = resultat.getString("encadrant");
				binome = resultat.getString("etu2");
				annee = resultat.getString("annee");
				semestre = resultat.getString("semestre");
				projet = map(id_projet,intitule,description,status,encadrant,binome,annee,semestre,id_affectation);
				list.add(projet);		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return list;
	}
	
	public void addProjet(String intitule, String description, int id_affectation) throws DAOException {
	   	Connection connexion = null;
		PreparedStatement statement = null;	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into projet(intitule, description, id_affectation) values(?,?,?)");
				statement.setString(1, intitule);
				statement.setString(2, description);
				statement.setInt(3, id_affectation);
			    statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public void modifyProjet(String intitule, String description, int id_projet) throws DAOException {
	   	Connection connexion = null;
		PreparedStatement statement = null;	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update projet set intitule=? , description=? where id_projet=?");
				statement.setString(1, intitule);
				statement.setString(2, description);
				statement.setInt(3, id_projet);
			    statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public List<Projet> getAllprojets_prof(String code, String annee1, String semestre1) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int id_projet;
		String intitule;
		String description;
		String status;
		String encadrant;
		String binome;
		String annee;
		String semestre;
		int id_affectation;	
		List<Projet> list = new ArrayList<Projet>();
		try { 
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT a.annee, a.semestre, concat(e1.nom,' ',e1.prenom) as etu2 , concat(e.nom,' ',e.prenom) as etu1 , a.id_affectation FROM affectation a JOIN etudiant e JOIN etudiant e1 JOIN professeur p on a.id_etudiant=e.code and a.id_etudiant1 = e1.code and a.id_encadrant=p.code where a.id_encadrant=? and annee=? and semestre=? order by id_affectation desc;");
			statement.setString(1, code);
			statement.setString(2, annee1);
			statement.setString(3, semestre1);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				Projet projet = new Projet();
				id_affectation = resultat.getInt("id_affectation");
				id_projet = getIdProjet(id_affectation);
				intitule = getIntitule(id_affectation);
				description = getDescription(id_affectation);
				status = getStatus(id_affectation);
				encadrant = resultat.getString("etu1");
				binome = resultat.getString("etu2");
				annee = resultat.getString("annee");
				semestre = resultat.getString("semestre");
				projet = map(id_projet,intitule,description,status,encadrant,binome,annee,semestre,id_affectation);
				list.add(projet);		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return list;
	}
	
	public void modifyProjet_prof(String description_prof, int id_projet) throws DAOException {
	   	Connection connexion = null;
		PreparedStatement statement = null;	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update projet set prof_comment=? where id_projet=?");
				statement.setString(1, description_prof);
				statement.setInt(2, id_projet);
			    statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
	}
	
	public int numberProjects(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(id_affectation) as count from affectation where id_etudiant=? or id_etudiant1=?");
			statement.setString(1, id_user);
			statement.setString(2, id_user);
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
	
	public int numberIndefinedProjects(String id_etudiant) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(id_projet) from (select id_projet,intitule from projet p join affectation a join etudiant e on p.id_affectation = a.id_affectation and a.id_etudiant = e.code where e.code=? union select id_projet,intitule from projet p join affectation a join etudiant e on p.id_affectation = a.id_affectation and a.id_etudiant1 = e.code where e.code=?) as new where intitule = ?");
			statement.setString(1, id_etudiant);
			statement.setString(2, id_etudiant);
			statement.setString(3, null);
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
	
	public int numberProjects_prof(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(distinct(semestre)) as count from affectation where id_encadrant=? and annee=extract(year from current_date)");
			statement.setString(1, id_user);
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
	
	public int numberAffectations_prof(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(id_affectation) as count from affectation where id_encadrant=? and annee=extract(year from current_date)");
			statement.setString(1, id_user);
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
}
