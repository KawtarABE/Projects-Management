package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Chart;
import com.JAVA.Beans.Recent;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;
import com.JAVA.DAO.DAOPhase;
import com.JAVA.DAO.DAOProjet;
import com.JAVA.DAO.DAOUser;

public class home_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public home_admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOUser obj = DAOFactory.getInstance().getUserDAO();
		String id_user = (String) request.getSession().getAttribute("id_user");
		int students = obj.numberStudents(id_user);
		int profs = obj.numberProfesseurs(id_user);
		int projets = obj.numberProjects(id_user);
		int projets_year = obj.numberProjects_year(id_user);
		List<Chart> list = obj.chart(id_user);
		request.setAttribute("list", list);
		request.setAttribute("students", students);
		request.setAttribute("profs", profs);
		request.setAttribute("projets", projets);
		request.setAttribute("year_projets", projets_year);
		request.getRequestDispatcher("/WEB-INF/admin/home_admin.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
