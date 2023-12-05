package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Event;
import com.JAVA.Beans.Message;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;



public class sent_mail_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sent_mail_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		String id_sender = (String) request.getSession().getAttribute("id_user");
		List<Message> messages = obj.getAllsent_messages(id_sender);	
		List<Integer> removedMessageIds = obj.getAllremoved_messages(id_sender);
		for (int i = 0; i < messages.size(); i++) {
		    if (removedMessageIds.contains(messages.get(i).getId())) {
		        messages.remove(i);
		        i--;
		    }
		}
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/WEB-INF/prof/sent_mail_prof.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}