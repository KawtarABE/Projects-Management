package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

import com.JAVA.DAO.DAOAffectation;
import com.JAVA.DAO.DAOFactory;

public class addAffectation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addAffectation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAffectation obj = DAOFactory.getInstance().getaffectationDAO();
		String admin = (String) request.getSession().getAttribute("id_user");
		String id_etudiant = request.getParameter("student1");
		String id_etudiant1 = request.getParameter("student2");
		String id_encadrant = request.getParameter("prof");
		String semestre = request.getParameter("semestre");
		String promo = request.getParameter("promo");
		Calendar cal = Calendar.getInstance();
     	int year = cal.get(Calendar.YEAR);
        String yearString = Integer.toString(year);
        obj.addAffectation(id_etudiant, id_etudiant1, id_encadrant, yearString, semestre, admin);
		request.setAttribute("promo", promo);
		request.setAttribute("success", "Affectation successfuly added");
		request.getRequestDispatcher("allAffectations_infos").forward(request, response);;
	}

}
