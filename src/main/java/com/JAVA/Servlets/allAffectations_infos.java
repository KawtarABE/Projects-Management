package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Affectation;
import com.JAVA.Beans.Prof;
import com.JAVA.Beans.Student;
import com.JAVA.DAO.DAOAffectation;
import com.JAVA.DAO.DAOEtudiant;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;
import com.JAVA.DAO.DAOUser;

public class allAffectations_infos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public allAffectations_infos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = (String) request.getSession().getAttribute("id_user");
		String promo = request.getParameter("promo");
		if( promo == null ) {
			promo = (String) request.getAttribute("promo");
		}
		DAOProf obj = DAOFactory.getInstance().getprofDAO();
		DAOEtudiant obj1 = DAOFactory.getInstance().getetudiantDAO();
		List<Student> students = obj1.getAlletudiants(promo, id_user);
		List<Prof> profs = obj.getAllprofesseurs(id_user);
		if( students.size() < 2) {
			request.setAttribute("erreur", "No students in the chosen promotion");
		}
		request.setAttribute("profs", profs);
		request.setAttribute("etudiants", students);
		request.setAttribute("promo", promo);
		request.getRequestDispatcher("addAffectation_1.jsp").forward(request, response);
	}

}
