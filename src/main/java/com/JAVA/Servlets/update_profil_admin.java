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




public class update_profil_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update_profil_admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUser obj = DAOFactory.getInstance().getUserDAO(); 
		String id_user = (String) request.getSession().getAttribute("id_user");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String numero = request.getParameter("num");
		String departement = request.getParameter("departement");
		obj.updateAdmin(nom,prenom,departement,id_user);
		obj.updateUser(id_user, nom, prenom, email, numero);
		request.setAttribute("success", "Your profil was successfuly updated");
		request.getRequestDispatcher("profil_admin").forward( request, response );
	}

}