package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.JAVA.Beans.Event;
import com.JAVA.Beans.Message;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;


@MultipartConfig(maxFileSize=169999999)
public class send_message extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public send_message() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		String id_sender = (String) request.getSession().getAttribute("id_user");
		String id_receiver = request.getParameter("receiver");
		int idresponse_to = 0; 
		if (request.getParameter("isresponse_to") != null) { 
				idresponse_to = Integer.parseInt(request.getParameter("isresponse_to")); 
		}
		String subject = request.getParameter("title");
		String message = request.getParameter("details");
		Part filePart = request.getPart("file");
		String fileName = null;
		long maxFileSize = 51200 ;
		long fileSize = 0;
		InputStream fileContent = null;
		if (!filePart.getSubmittedFileName().isEmpty()) {
           fileName = filePart.getSubmittedFileName();
           fileContent = filePart.getInputStream();
           fileSize = filePart.getSize();
		}
        if(fileSize > maxFileSize) {
     	   request.setAttribute("erreur", "File size is too large");
        }
        obj.insertMessage(id_sender, id_receiver, subject, message, idresponse_to, fileName, fileContent);
        if( idresponse_to != 0) {
        	request.getRequestDispatcher("mail").forward( request, response );
        }
		request.getRequestDispatcher("compose").forward( request, response );
	}

}