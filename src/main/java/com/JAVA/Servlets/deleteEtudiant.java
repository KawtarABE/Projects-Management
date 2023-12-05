package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.JAVA.DAO.DAOEtudiant;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;

public class deleteEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteEtudiant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEtudiant obj = DAOFactory.getInstance().getetudiantDAO();
		String code = request.getParameter("code");
		obj.deleteEtudiant(code);
		String promo = request.getParameter("promo");
		request.setAttribute("promo", promo);
		request.getRequestDispatcher("allEtudiant_promo").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
