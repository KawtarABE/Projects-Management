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




public class profil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public profil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = (String) request.getSession().getAttribute("id_user");
		DAOUser obj = DAOFactory.getInstance().getUserDAO(); 
		Student etudiant = obj.getStudentInfo(id_user);
		request.setAttribute("etudiant", etudiant);
		request.getRequestDispatcher("/WEB-INF/profil_etudiant.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}