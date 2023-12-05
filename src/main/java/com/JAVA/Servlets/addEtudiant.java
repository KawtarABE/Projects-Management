package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Prof;
import com.JAVA.DAO.DAOEtudiant;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;
import com.JAVA.DAO.DAOUser;

public class addEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addEtudiant() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEtudiant obj = DAOFactory.getInstance().getetudiantDAO();
		DAOUser obj1 = DAOFactory.getInstance().getUserDAO();
		String admin = (String) request.getSession().getAttribute("id_user");
		String code= request.getParameter("code");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String filiere = request.getParameter("filiere");
		String promo = request.getParameter("promo");
		String email = request.getParameter("email");
		String num = request.getParameter("num");	
		String password = request.getParameter("password");
		obj.addEtudiant(code, nom, prenom, promo, password, filiere, admin);;
		obj1.insertUser(code, nom, prenom, password, "etudiant", email, num);
		request.getRequestDispatcher("allEtudiants").forward( request, response );
	}

}
