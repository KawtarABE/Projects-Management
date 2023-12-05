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
import com.JAVA.DAO.DAOBinomes;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;


@MultipartConfig(maxFileSize=169999999)
public class sendmessage_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sendmessage_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		DAOBinomes obj1 = DAOFactory.getInstance().getbinomesDAO();
		String id_sender = (String) request.getSession().getAttribute("id_user");
		String subject = request.getParameter("title");
		String message = request.getParameter("details");
		Part filePart = request.getPart("file");
		List<String> receivers;
		String fileName = null;
		int idresponse_to = 0; 
		long maxFileSize = 51200 ;
		long fileSize = 0;
		int id_receivers = 0;
		String affectations = null;
		InputStream fileContent = null;
		if (!filePart.getSubmittedFileName().isEmpty()) {
           fileName = filePart.getSubmittedFileName();
           fileContent = filePart.getInputStream();
           fileSize = filePart.getSize();
		}
        if(fileSize > maxFileSize) {
     	   request.setAttribute("erreur", "File size is too large");
        }
        if( request.getParameter("receiver") != null) {
        	id_receivers = Integer.parseInt(request.getParameter("receiver"));
        	receivers = obj1.getIds(id_receivers);
        }
        else {
    		affectations = request.getParameter("affectation");
        	receivers = obj1.getIds_semestre(affectations, id_sender);
        }
        for (String item : receivers) {
        	obj.insertMessage(id_sender, item, subject, message, idresponse_to, fileName, fileContent);
        }
		request.getRequestDispatcher("compose_prof").forward( request, response );
	}
}