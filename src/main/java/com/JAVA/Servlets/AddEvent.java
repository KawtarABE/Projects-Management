package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.List;
import com.JAVA.DAO.DAOAddEvent;
import com.JAVA.DAO.DAOFactory;


public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddEvent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int id_affectation = Integer.parseInt(request.getParameter("affectation"));
		String type = request.getParameter("type");
		String details = request.getParameter("details");
		String dateString = request.getParameter("date");
//		String pattern = "yyyy-mm-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date date = simpleDateFormat.parse(dateString);
		String time = request.getParameter("time");
		List<String> id_users;
		
		DAOAddEvent obj = DAOFactory.getInstance().AddeventDAO();
		id_users = obj.getIdetudiant(id_affectation);
		
		obj.insertEvent(id_users.get(0), title, type, details, dateString, time, id_affectation);
		obj.insertEvent(id_users.get(1), title, type, details, dateString, time, id_affectation);
		obj.insertEvent(id_users.get(2), title, type, details, dateString, time, id_affectation);
		response.sendRedirect("events_prof");
		
	}

}
