package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Student;
import com.JAVA.DAO.DAOEtudiant;
import com.JAVA.DAO.DAOFactory;

public class allEtudiant_promo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public allEtudiant_promo() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEtudiant obj = DAOFactory.getInstance().getetudiantDAO();
     	String admin = (String) request.getSession().getAttribute("id_user");
		String promo = request.getParameter("promo");
		if( promo == null) {
			promo = (String) request.getAttribute("promo");
		}
		List<Student> etudiants = obj.getAlletudiants(promo, admin);
		List<String> list = obj.getAllpromos(admin);
		request.setAttribute("promos",list);
		request.setAttribute("promotion", promo);
		request.setAttribute("etudiants", etudiants);
		request.getRequestDispatcher("WEB-INF/admin/allEtudiants.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEtudiant obj = DAOFactory.getInstance().getetudiantDAO();
     	String admin = (String) request.getSession().getAttribute("id_user");
		String promo = request.getParameter("promo");
		List<Student> etudiants = obj.getAlletudiants(promo, admin);
		List<String> list = obj.getAllpromos(admin);
		request.setAttribute("promos",list);
		request.setAttribute("promotion", promo);
		request.setAttribute("etudiants", etudiants);
		request.getRequestDispatcher("WEB-INF/admin/allEtudiants.jsp").forward(request, response);
	}

}
