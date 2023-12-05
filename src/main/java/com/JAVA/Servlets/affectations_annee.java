package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Projet;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProjet;
import com.JAVA.DAO.DAOUser;

public class affectations_annee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public affectations_annee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		String id_user = (String) request.getSession().getAttribute("id_user");
		String annee = request.getParameter("annee");
		String semestre = request.getParameter("semestre");
		List<Projet> projets = obj.getAllprojets_prof(id_user,annee,semestre);
		DAOUser obj1 = DAOFactory.getInstance().getUserDAO();
		List<String> annees = obj1.getAll_years(id_user);
		if( projets.size() == 0 ) {
			request.setAttribute("no_affectation", "You have no preference for the semester and year chose");
		}
		request.setAttribute("annee", annee);
		request.setAttribute("semestre", semestre);
		request.setAttribute("annees", annees);
		request.setAttribute("projets", projets);
		request.getRequestDispatcher("/WEB-INF/prof/affectations_prof.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProjet obj = DAOFactory.getInstance().getprojetDAO();
		String id_user = (String) request.getSession().getAttribute("id_user");
		String annee = request.getParameter("annee");
		String semestre = request.getParameter("semestre");
		List<Projet> projets = obj.getAllprojets_prof(id_user,annee,semestre);
		DAOUser obj1 = DAOFactory.getInstance().getUserDAO();
		List<String> annees = obj1.getAll_years(id_user);
		if( projets.size() == 0 ) {
			request.setAttribute("no_affectation", "You have no preference for the semester and year chose");
		}
		request.setAttribute("annee", annee);
		request.setAttribute("semestre", semestre);
		request.setAttribute("annees", annees);
		request.setAttribute("projets", projets);
		request.getRequestDispatcher("/WEB-INF/prof/affectations_prof.jsp").forward( request, response );
	}

}
