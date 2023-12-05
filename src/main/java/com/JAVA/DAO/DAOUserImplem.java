package com.JAVA.DAO;

import java.sql.Connection;
import java.util.List;

import com.JAVA.Beans.Admin;
import com.JAVA.Beans.Chart;
import com.JAVA.Beans.Message;
import com.JAVA.Beans.Prof;
import com.JAVA.Beans.Recent;
import com.JAVA.Beans.Student;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOUserImplem implements DAOUser {

	private DAOFactory daoFactory;

    public DAOUserImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }	
	
	@Override 
	public boolean authentification(String code,String password) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		boolean status = false;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users WHERE id=? and password=?");
			statement.setString(1, code);
			statement.setString(2, password);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				status = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public String getUserStatus(String code) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String status = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users WHERE id=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				status = resultat.getString("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	public Student getStudentInfo(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		Student etudiant = new Student();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users join etudiant on users.id = etudiant.code WHERE users.id=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				etudiant.setCode(code);
				etudiant.setPrenom(resultat.getString("prenom"));
				etudiant.setNom(resultat.getString("nom"));
				etudiant.setEmail(resultat.getString("email"));
				etudiant.setNumero(resultat.getString("numero"));
				etudiant.setPromo(resultat.getString("promo"));
				etudiant.setFiliere(resultat.getString("filiere"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;
	}
	
	public void updateStudent(String nom, String prenom, String promo, String filiere, String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("UPDATE etudiant SET nom=?, prenom=?, promo=?, filiere=? WHERE code=?");
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, promo);
			statement.setString(4, filiere);
			statement.setString(5, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(String code, String nom, String prenom, String email, String numero) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update users set nom=?, prenom=?, email=?, numero=? where id=?");
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, email);
			statement.setString(4, numero);
			statement.setString(5, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPassword(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String password = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select password from users where id=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while( resultat.next()) {
				password = resultat.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return password;
	}
	
	public void updatePassword(String code, String password) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update users set password=? where id=?");
			statement.setString(1, password);
			statement.setString(2, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Prof getProfInfo(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		Prof prof = new Prof();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users join professeur on users.id = professeur.code WHERE users.id=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				prof.setCode(code);
				prof.setPrenom(resultat.getString("prenom"));
				prof.setNom(resultat.getString("nom"));
				prof.setEmail(resultat.getString("email"));
				prof.setNumero(resultat.getString("numero"));
				prof.setDomaine(resultat.getString("domaine"));
				prof.setDepartement(resultat.getString("departement"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prof;
	}

	public void updateProf(String nom, String prenom, String domaine, String departement, String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("UPDATE professeur SET nom=?, prenom=?, domaine=?, departement=? WHERE code=?");
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, domaine);
			statement.setString(4, departement);
			statement.setString(5, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getAll_years(String id_prof) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String annee;
		List<String> list = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(annee) from affectation where id_encadrant=? order by annee");
			statement.setString(1, id_prof);
			resultat = statement.executeQuery();
			while( resultat.next()) {
				annee = resultat.getString("annee");
				list.add(annee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAll_semestres(String id_prof) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String semestre;
		List<String> list = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(semestre) from affectation where id_encadrant=? and annee=extract(year from current_date) order by semestre");
			statement.setString(1, id_prof);
			resultat = statement.executeQuery();
			while( resultat.next()) {
				semestre = resultat.getString("semestre");
				list.add(semestre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public Admin getAdminInfo(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		Admin admin = new Admin();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users join administrateur on users.id = administrateur.code WHERE users.id=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				admin.setCode(code);
				admin.setPrenom(resultat.getString("prenom"));
				admin.setNom(resultat.getString("nom"));
				admin.setEmail(resultat.getString("email"));
				admin.setNumero(resultat.getString("numero"));
				admin.setDepartement(resultat.getString("filiere"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	public void updateAdmin(String nom, String prenom, String departement, String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("UPDATE administrateur SET nom=?, prenom=?, filiere=? WHERE code=?");
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, departement);
			statement.setString(4, code);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int numberStudents(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count from etudiant where admin=?");
			statement.setString(1, admin);
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
	
	public int numberProfesseurs(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count from professeur where admin=?");
			statement.setString(1, admin);
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
	
	public int numberProjects(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count from affectation where admin=?");
			statement.setString(1, admin);
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
	
	public int numberProjects_year(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count from affectation where admin=? and annee=extract(year from current_date)");
			statement.setString(1, admin);
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
	
	public List<Chart> chart(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<Chart> list = new ArrayList<Chart>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(*) as count, annee from affectation where admin=? group by annee limit 4");
			statement.setString(1, admin);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				Chart recent = new Chart();
				recent.setCount(resultat.getInt("count"));
				recent.setAnnee(resultat.getString("annee"));
				list.add(recent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	
	public void insertUser(String code, String nom, String prenom, String password, String status, String email, String numero) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
			statement.setString(1, code);
			statement.setString(2, nom);
			statement.setString(3, prenom);
			statement.setString(4, password);
			statement.setString(5, status);
			statement.setString(6, email);
			statement.setString(7, numero);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getDapartement(String code) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String departement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select filiere from administrateur where code=?");
			statement.setString(1, code);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				departement = resultat.getString("filiere");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return departement;	
	}
	
	public List<String> getAll_years_admin(String admin) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String annee;
		List<String> list = new ArrayList<String>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(annee) from affectation where admin=? order by annee");
			statement.setString(1, admin);
			resultat = statement.executeQuery();
			while( resultat.next()) {
				annee = resultat.getString("annee");
				list.add(annee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	 
}
