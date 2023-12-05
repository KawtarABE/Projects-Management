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

public class allphases extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public allphases() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO();
		DAOProjet obj1 = DAOFactory.getInstance().getprojetDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));	
		int id_projet = obj1.getIdProjet(id_affectation);
		if( id_projet != 0) {
	 		List<Phase> phases = obj.getAllphases(id_projet);
			request.setAttribute("phases", phases);
		}
		request.setAttribute("id_projet", id_projet);
		request.setAttribute("id_affectation", id_affectation);
		request.getRequestDispatcher("/WEB-INF/allphases.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

