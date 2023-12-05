package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Projet;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProjet;

import java.util.List;

public class projet_etudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public projet_etudiant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		String id_user = (String) request.getSession().getAttribute("id_user");
		List<Projet> projets = obj.getAllprojets(id_user);
		request.setAttribute("projets", projets);
		request.getRequestDispatcher("/WEB-INF/projets_etudiant.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

