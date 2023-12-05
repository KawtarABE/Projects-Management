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

public class addprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addprojet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));	
		String intitule = request.getParameter("title");
		String description = request.getParameter("description");
		int id_projet = obj.getIdProjet(id_affectation);
		if ( id_projet == 0) {
			obj.addProjet(intitule, description, id_affectation);
		} else {
			obj.modifyProjet(intitule, description, id_projet);
		}
		request.setAttribute("success", "Le projet a été modifié");
		request.setAttribute("id_affectation", id_affectation);
		request.getRequestDispatcher("intitule_projet").forward( request, response );
	}

}

