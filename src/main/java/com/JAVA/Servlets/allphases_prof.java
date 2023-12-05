package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Phase;
import com.JAVA.Beans.Projet;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOPhase;
import com.JAVA.DAO.DAOProjet;

import java.util.List;

public class allphases_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public allphases_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO();
		DAOProjet obj1 = DAOFactory.getInstance().getprojetDAO();
		String annee = request.getParameter("annee");
		String semestre = request.getParameter("semestre");
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));	
		int id_projet = obj1.getIdProjet(id_affectation);
		if( id_projet != 0) {
	 		List<Phase> phases = obj.getAllphases(id_projet);
			request.setAttribute("phases", phases);
		}
		request.setAttribute("annee", annee);
		request.setAttribute("semestre", semestre);
		request.setAttribute("id_projet", id_projet);
		request.setAttribute("id_affectation", id_affectation);
		request.getRequestDispatcher("/WEB-INF/prof/allphases_prof.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

