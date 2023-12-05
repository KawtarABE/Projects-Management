package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Prof;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;
import com.JAVA.DAO.DAOUser;

public class addProf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addProf() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProf obj = DAOFactory.getInstance().getprofDAO();
		DAOUser obj1 = DAOFactory.getInstance().getUserDAO();
		String admin = (String) request.getSession().getAttribute("id_user");
		String code= request.getParameter("code");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String domaine = request.getParameter("domaine");
		String email = request.getParameter("email");
		String num = request.getParameter("num");	
		String password = request.getParameter("password");
		String departement = obj1.getDapartement(admin);
		obj.addProf(code, nom, prenom, domaine, departement, admin);
		obj1.insertUser(code, nom, prenom, password, "professeur", email, num);
		request.getRequestDispatcher("allProfs").forward( request, response );
	}

}
