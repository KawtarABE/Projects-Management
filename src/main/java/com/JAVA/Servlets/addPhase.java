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

public class addPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addPhase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));	
		int id_projet = Integer.parseInt(request.getParameter("id_projet"));	
		String phase = request.getParameter("title");
		String description = request.getParameter("description");
		if( id_projet != 0) {
			obj.addPhase(id_projet, phase, description);
			request.setAttribute("success", "One phase added");
		}
		else {
			request.setAttribute("erreur", "Pair has not choose the project yet, you can't add a phase");
		}
		request.setAttribute("annee", request.getParameter("annee"));
		request.setAttribute("semestre", request.getParameter("semestre"));
		request.setAttribute("id_affectation", id_affectation);
		request.getRequestDispatcher("phase_form").forward( request, response );
	}

}

