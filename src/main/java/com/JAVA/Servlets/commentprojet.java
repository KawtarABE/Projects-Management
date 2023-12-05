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

public class commentprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public commentprojet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));	
		String prof_comment = request.getParameter("description_prof");
		int id_projet = obj.getIdProjet(id_affectation);
		obj.modifyProjet_prof(prof_comment, id_projet);
		request.setAttribute("success", "Le projet a été modifié");
		request.setAttribute("id_affectation", id_affectation);
		request.setAttribute("annee", request.getParameter("annee"));
		request.setAttribute("semestre", request.getParameter("semestre"));
		request.getRequestDispatcher("intitule_projet_prof").forward( request, response );
	}

}

