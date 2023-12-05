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

public class updateprof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateprof() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUser obj = DAOFactory.getInstance().getUserDAO();
		String admin = (String) request.getSession().getAttribute("id_user");
		String code= request.getParameter("code");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String domaine = request.getParameter("domaine");
		String email = request.getParameter("email");
		String num = request.getParameter("num");	
		String departement = obj.getDapartement(admin);
		obj.updateProf(nom, prenom, domaine, departement, code);
		obj.updateUser(code, nom, prenom, email, num);
		request.getRequestDispatcher("allProfs").forward( request, response );
	}

}
