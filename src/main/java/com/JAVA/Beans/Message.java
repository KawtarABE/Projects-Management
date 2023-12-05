package com.JAVA.Beans;

import java.io.InputStream;

public class Message {
	private int id;
	private String id_sender;
	private String sender;
	private String receiver;
	private String subject;
	private String message;
	private String date_envoie;
	private boolean is_read;
	private int isresponse_to;
	private String file_name;
	private InputStream file_data;
	
	public String getId_sender() {
		return id_sender;
	}
	public void setId_sender(String id_sender) {
		this.id_sender = id_sender;
	} 
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public InputStream getFile_data() {
		return file_data;
	}
	public void setFile_data(InputStream file_data) {
		this.file_data = file_data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String seinder) {
		this.sender = seinder;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate_envoie() {
		return date_envoie;
	}
	public void setDate_envoie(String date_envoie) {
		this.date_envoie = date_envoie;
	}
	public boolean isIs_read() {
		return is_read;
	}
	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}
	public int getIsresponse_to() {
		return isresponse_to;
	}
	public void setIsresponse_to(int isresponse_to) {
		this.isresponse_to = isresponse_to;
	}
	
	
	

}
