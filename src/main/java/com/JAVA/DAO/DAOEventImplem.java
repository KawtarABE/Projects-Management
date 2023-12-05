package com.JAVA.DAO;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.JAVA.Beans.Event;
import java.time.LocalDate;

public class DAOEventImplem implements DAOEvent{

	private DAOFactory daoFactory;

    public DAOEventImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	@SuppressWarnings("deprecation")
	public static Event map(ResultSet resultat) throws SQLException {
    	Event event = new Event();
    	event.setDate(resultat.getDate("date"));
    	event.setTitle(resultat.getString("title"));
    	event.setType(resultat.getString("type"));
    	event.setDetail(resultat.getString("detail"));
    	event.setTime(resultat.getString("heure"));
    	event.setProjet(resultat.getString("semestre"));
    	event.setAvec(resultat.getString("avec"));
    	event.setStatus(resultat.getString("status"));
    	return event;  	
    }

	@Override
	public List<Event> getAllevents(String id_user) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<Event> list = new ArrayList<Event>();
		Event event;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select ev.title as title, ev.type as type, ev.status as status, ev.detail as detail, ev.date as date, ev.heure as heure, a.semestre as semestre, concat(pr.nom,' ',pr.prenom) as avec from events ev join affectation a join professeur pr on ev.id_affectation = a.id_affectation and a.id_encadrant = pr.code where ev.id_user=? order by ev.id desc;");
			statement.setString(1, id_user);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				event = map(resultat);
				list.add(event);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	 }
	
	
	public List<Event> getAllevents_prof(String id_user) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		List<Event> list = new ArrayList<Event>();
		Event event;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select ev.title, ev.type, ev.detail, ev.status as status, ev.date, ev.heure, a.semestre, concat(e.nom,' ',e.prenom,' et ',e1.nom,' ',e1.prenom) as avec from events ev join affectation a join etudiant e join etudiant e1 on ev.id_affectation = a.id_affectation and a.id_etudiant = e.code and a.id_etudiant1 = e1.code where ev.id_user=? order by ev.id desc");
			statement.setString(1, id_user);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				event = map(resultat);
				list.add(event);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	 }
	
	
	public void annulerEvent(String date, String heure, String title) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("update events set status=? where title=? and date=? and heure=?");
			statement.setString(1, "l'événement a été annulé");
			statement.setString(2, title);
			statement.setString(3, date);
			statement.setString(4, heure);
		    statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int comingEvents(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT count(id) as count FROM events WHERE (date > CURDATE() or (date = curdate() AND heure > NOW())) and id_user=?");
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

    
   