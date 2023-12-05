package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import com.JAVA.Beans.Message;
import com.JAVA.Beans.User;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;



public class compose extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public compose() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		String id_sender = (String) request.getSession().getAttribute("id_user");
		List<User> encadrants = obj.getEncadrants(id_sender);
		List<User> binomes = obj.getBinomes(id_sender);
		request.setAttribute("encadrants", encadrants);
		request.setAttribute("binomes", binomes);
		request.setAttribute("erreur", request.getAttribute("erreur"));
		request.getRequestDispatcher("/WEB-INF/compose.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}