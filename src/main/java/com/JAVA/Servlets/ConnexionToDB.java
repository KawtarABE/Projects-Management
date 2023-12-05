package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.JAVA.DAO.Connexion;
import com.JAVA.DAO.DAOFactory;


public class ConnexionToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConnexionToDB() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connexion obj = DAOFactory.getInstance().getConnexionDao();
		boolean conn = obj.getConnexion();
		String mssg;
		if(conn == true) {
			mssg = "connexion à la base réussie" ; 
		}
		else  { 
			mssg = "connexion à la base échouées" ; 
		}
		request.setAttribute("mssg", mssg);
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}