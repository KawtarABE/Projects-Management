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



public class Message_details_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Message_details_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		int id_message = Integer.parseInt(request.getParameter("message_id"));
	    obj.updateReadStatus(id_message, 1);
		Message message = obj.getMessage(id_message);
		int idresponse_to = message.getIsresponse_to();
		Message message1 = obj.getMessage(idresponse_to);
		request.setAttribute("message", message);
		request.setAttribute("message_responseto", message1);
		request.getRequestDispatcher("/WEB-INF/prof/message_details_prof.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
