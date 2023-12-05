package com.JAVA.DAO;

import java.io.InputStream;
import java.util.List;
import com.JAVA.Beans.Message;
import com.JAVA.Beans.User;

public interface DAOMessage {
	
	String getUser(String id_user);
	List<Message> getAllreceived_messages(String receiver);
	List<Message> getAllsent_messages(String sender);
	Message getMessage(int id_message);
	void updateReadStatus(int messageId, int isRead);
	List<User> getEncadrants(String code_sender);
	List<User> getBinomes(String code_sender);
	void insertMessage(String sender, String receiver, String subject, String message, int idresponse_to, String file_name, InputStream file_data);
	void removeMessage(int id_message, String id_user);
	List<Integer> getAllremoved_messages(String id_user);
	int unreadNumber(String id_user);
	

}
