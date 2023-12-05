package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Student;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOUser;




public class change_password extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public change_password() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUser obj = DAOFactory.getInstance().getUserDAO(); 
		String id_user = (String) request.getSession().getAttribute("id_user");
		String old_password = request.getParameter("old_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		String status = request.getParameter("prof");
		String admin = request.getParameter("admin");
		String password = obj.getPassword(id_user);
		
		if(password.equals(old_password) & new_password.equals(confirm_password)) {
		obj.updatePassword(id_user, new_password);
		request.setAttribute("success", "Your password was successfuly changed");
		}
		
		if( !new_password.equals(confirm_password) ) {
			request.setAttribute("erreur", "password mismatch");
		} 
					
		if( !password.equals(old_password) ) {
			request.setAttribute("erreur", "Old password incorrect");
		} 
		
		if(status != null) {
			request.getRequestDispatcher("password_prof.jsp").forward( request, response );
		}
		
		if(admin != null) {
			request.getRequestDispatcher("password_admin.jsp").forward( request, response );
		}
		
		request.getRequestDispatcher("password.jsp").forward( request, response );
	}

}