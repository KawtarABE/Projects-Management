package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Event;
import com.JAVA.DAO.Connexion;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import java.util.List;

public class events extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public events() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEvent obj = DAOFactory.getInstance().geteventDao();
		String id_user = (String) request.getSession().getAttribute("id_user");
		List<Event> events = obj.getAllevents(id_user);
		request.setAttribute("events", events);
		request.getRequestDispatcher("/WEB-INF/Events.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
