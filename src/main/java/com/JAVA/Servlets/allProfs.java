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

public class allProfs extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public allProfs() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DAOProf obj = DAOFactory.getInstance().getprofDAO();
			String id = (String) request.getSession().getAttribute("id_user");
			request.setAttribute("id", id);
			List<Prof> professeurs = obj.getAllprofesseurs(id);
			request.setAttribute("professeurs", professeurs);
			request.getRequestDispatcher("WEB-INF/admin/allProfesseurs.jsp").forward( request, response );
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
