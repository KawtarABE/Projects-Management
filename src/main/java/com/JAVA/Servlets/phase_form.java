package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class phase_form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public phase_form() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_projet = Integer.parseInt(request.getParameter("id_projet"));
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));
		String annee = request.getParameter("annee");
		String semestre = request.getParameter("semestre");
		if(id_affectation == 0) {
			id_projet = (int) request.getAttribute("id_projet");
			id_affectation = (int) request.getAttribute("id_affectation");
			annee = (String) request.getAttribute("annee");
			semestre = (String) request.getAttribute("semestre");
		}	
		request.setAttribute("success", request.getAttribute("success"));
		request.setAttribute("erreur", request.getAttribute("erreur"));
		request.setAttribute("id_projet", id_projet);
		request.setAttribute("id_affectation", id_affectation);
		request.setAttribute("annee", annee);
		request.setAttribute("semestre", semestre);
		request.getRequestDispatcher("WEB-INF/prof/Phase_form.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
