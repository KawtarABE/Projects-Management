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



public class delete_message extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete_message() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		String id_user = (String) request.getSession().getAttribute("id_user");
		int id_message = Integer.parseInt(request.getParameter("message_id"));
		String action = request.getParameter("action");
        obj.removeMessage(id_message,id_user);
        if( action.equals("send")) {
        	request.getRequestDispatcher("sent_mail").forward( request, response );
        }
        
        else {
        	request.getRequestDispatcher("mail").forward( request, response );
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
