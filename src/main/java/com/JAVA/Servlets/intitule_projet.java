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

public class intitule_projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public intitule_projet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));
		if( id_affectation == 0) {
			id_affectation = (int) request.getAttribute("id_affectation");
		}
		String intitule = obj.getIntitule(id_affectation);
		String description = obj.getDescription(id_affectation);
		String prof_description = obj.getProf_description(id_affectation);
		request.setAttribute("success",request.getAttribute("success"));
		request.setAttribute("id_affectation", id_affectation);
		request.setAttribute("description", description);
		request.setAttribute("prof_description", prof_description);
		request.setAttribute("intitule", intitule);
		request.getRequestDispatcher("/WEB-INF/Validation_projet.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
