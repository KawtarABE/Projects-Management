package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOUser;

public class Validation_signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Validation_signin() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String code = request.getParameter("code");
			String password = request.getParameter("password");
			
			DAOUser obj = DAOFactory.getInstance().getUserDAO();
			boolean isValid = obj.authentification(code,password);
			
			if(isValid) {
	            request.getSession().setAttribute("id_user", code);
	            
	            
				String status = obj.getUserStatus(code);
					if(status.equals("etudiant")) {
						response.sendRedirect("home_etudiant");		
					}
					
					else if(status.equals("professeur")) {
						response.sendRedirect("home_prof");	
					}
					
					else if (status.equals("administrateur")) {
						response.sendRedirect("home_admin");
					}
			}
			else {
		        request.setAttribute("erreur", "Invalid username or password");
		        request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
		    }
	}
}
