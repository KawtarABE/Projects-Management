package com.JAVA.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import com.JAVA.Beans.Message;
import com.JAVA.Beans.User;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOMessageImplem implements DAOMessage {

	private DAOFactory daoFactory;

    public DAOMessageImplem( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public static Message map(int Id, String id_sender, String sender, String recepient, String message1, String subject, String created_at, boolean is_read, int isresponse_to, String file_name, InputStream file_data) throws SQLException {
    	Message message = new Message();
    	message.setId(Id);
    	message.setId_sender(id_sender);
    	message.setSender(sender);
    	message.setReceiver(recepient);
    	message.setMessage(message1);
    	message.setSubject(subject);
    	message.setDate_envoie(created_at);
    	message.setIs_read(is_read);
    	message.setIsresponse_to(isresponse_to);
    	message.setFile_name(file_name);
    	message.setFile_data(file_data);
    	return message;  	
    }
	
	@Override 
	public String getUser(String id_user) throws DAOException { 
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String user = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM users WHERE id=?");
			statement.setString(1, id_user);
			resultat = statement.executeQuery();
			while(resultat.next()) {
				user = resultat.getString("nom") + " " + resultat.getString("prenom");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Message> getAllreceived_messages(String id_receiver) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int Id;
		String id_sender;
		String id_recepient;
		String sender;
		String receiver;
		String message1;
		String subject;
		String created_at;
		boolean is_read;
		int isresponse_to;
		String file_name;
		InputStream file_data;
		Message message = new Message();
		List<Message> list = new ArrayList<Message>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM messages WHERE recipient=?  order by created_at DESC");
			statement.setString(1, id_receiver);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				Id = resultat.getInt("id");
				id_sender = resultat.getString("sender");
				id_recepient = resultat.getString("recipient");
				sender = getUser(id_sender);
				receiver = getUser(id_recepient);
				message1 = resultat.getString("message");
				subject = resultat.getString("subject");
				created_at = resultat.getString("created_at");
				is_read = resultat.getBoolean("is_read");
				isresponse_to = resultat.getInt("isresponse_to");
				file_name = resultat.getString("file_name");
				file_data = resultat.getBinaryStream("file_data");
				message = map(Id, id_sender, sender, receiver, message1, subject, created_at, is_read, isresponse_to,file_name,file_data);
				list.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	 }
	
	
	public List<Message> getAllsent_messages(String id_sender) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int Id;
		String id_sender1;
		String id_recepient;
		String sender;
		String receiver;
		String message1;
		String subject;
		String created_at;
		boolean is_read;
		int isresponse_to;
		String file_name;
		InputStream file_data;
		Message message = new Message();
		List<Message> list = new ArrayList<Message>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM messages WHERE sender=? order by created_at DESC");
			statement.setString(1, id_sender);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				Id = resultat.getInt("id");
				id_sender1 = resultat.getString("sender");
				id_recepient = resultat.getString("recipient");
				sender = getUser(id_sender1);
				receiver = getUser(id_recepient);
				message1 = resultat.getString("message");
				subject = resultat.getString("subject");
				created_at = resultat.getString("created_at");
				is_read = resultat.getBoolean("is_read");
				isresponse_to = resultat.getInt("isresponse_to");
				file_name = resultat.getString("file_name");
				file_data = resultat.getBinaryStream("file_data");
				message = map(Id, id_sender, sender, receiver, message1, subject, created_at, is_read, isresponse_to,file_name,file_data);
				list.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	 }
	
	public Message getMessage(int id_message) throws DAOException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		int Id;
		String id_sender;
		String id_recepient;
		String sender;
		String receiver;
		String message1;
		String subject;
		String created_at;
		boolean is_read;
		int isresponse_to;
		String file_name;
		InputStream file_data;
		Message message = new Message();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM messages WHERE id=?");
			statement.setInt(1, id_message);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				Id = resultat.getInt("id");
				id_sender = resultat.getString("sender");
				id_recepient = resultat.getString("recipient");
				sender = getUser(id_sender);
				receiver = getUser(id_recepient);
				message1 = resultat.getString("message");
				subject = resultat.getString("subject");
				created_at = resultat.getString("created_at");
				is_read = resultat.getBoolean("is_read");
				isresponse_to = resultat.getInt("isresponse_to");
				file_name = resultat.getString("file_name");
				file_data = resultat.getBinaryStream("file_data");
				message = map(Id, id_sender, sender, receiver, message1, subject, created_at, is_read, isresponse_to,file_name,file_data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return message;
	 }
	
    public void updateReadStatus(int messageId, int isRead) {
		Connection connexion = null;
		PreparedStatement statement = null;
        try {
        	connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("UPDATE messages SET is_read = ? WHERE id = ?");
            statement.setInt(1, isRead);
            statement.setInt(2, messageId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<User> getEncadrants(String code_sender) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_encadrant;
		String user_name;
		List<User> list = new ArrayList<User>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(id_encadrant) from affectation where annee=extract(year from current_date) and id_etudiant1=? or id_etudiant=?");
			statement.setString(1, code_sender);
			statement.setString(2, code_sender);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				User encadrant = new User();
				id_encadrant = resultat.getString("id_encadrant");
				user_name = getUser(id_encadrant);
				encadrant.setNom(user_name);
				encadrant.setCode(id_encadrant);
				list.add(encadrant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
    }
    
    public List<User> getBinomes(String code_sender) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat;
		String id_binome;
		String user_name;
		List<User> list = new ArrayList<User>();	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select distinct(id_etudiant) as id_binome from affectation where annee=extract(year from current_date) and id_etudiant1=? union select distinct(id_etudiant1) as id_binome from affectation where annee=extract(year from current_date) and id_etudiant=?");
			statement.setString(1, code_sender);
			statement.setString(2, code_sender);
		    resultat = statement.executeQuery();
			while(resultat.next()) {
				User binome = new User();
				id_binome= resultat.getString("id_binome");
				user_name = getUser(id_binome);
				binome.setNom(user_name);
				binome.setCode(id_binome);
				list.add(binome);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
    }
    
    public void insertMessage(String sender, String receiver, String subject, String message,int idresponse_to, String file_name, InputStream file_data) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into messages(sender, recipient, message, isresponse_to, subject, file_name, file_data) values(?,?,?,?,?,?,?)");
			statement.setString(1, sender);
			statement.setString(2, receiver);
			statement.setString(3, message);
			statement.setInt(4, idresponse_to);
			statement.setString(5, subject);
			statement.setString(6, file_name);
			statement.setBlob(7, file_data);
		    statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
	
    
    public void removeMessage(int id_message, String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("insert into removed_messages(id_user, id_message) values(?,?)");
			statement.setString(1, id_user);
			statement.setInt(2, id_message);
		    statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    public List<Integer> getAllremoved_messages(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int id_message;
		List<Integer> list = new ArrayList<Integer>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select id_message from removed_messages where id_user=?");
			statement.setString(1, id_user);
		    resultat = statement.executeQuery();
		    while(resultat.next()) {
		    	id_message = resultat.getInt("id_message");
		    	list.add(id_message);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
    }
    
    public int unreadNumber(String id_user) throws DAOException {
    	Connection connexion = null;
		PreparedStatement statement = null;	
		ResultSet resultat;
		int count = 0;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("select count(id) as count from messages where is_read=0 and recipient=?");
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
