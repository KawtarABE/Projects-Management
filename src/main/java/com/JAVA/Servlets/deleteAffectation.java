package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.JAVA.DAO.DAOAffectation;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;

public class deleteAffectation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteAffectation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAffectation obj = DAOFactory.getInstance().getaffectationDAO();
		int code = Integer.parseInt(request.getParameter("code"));
		obj.deleteAffectation(code);
		request.setAttribute("annee", request.getParameter("annee"));
		request.setAttribute("semestre", request.getParameter("semestre"));
		request.getRequestDispatcher("allAffectations_annee").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
