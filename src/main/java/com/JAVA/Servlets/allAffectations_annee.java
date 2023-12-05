package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Affectation;
import com.JAVA.DAO.DAOAffectation;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOUser;

public class allAffectations_annee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public allAffectations_annee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = (String) request.getSession().getAttribute("id_user");
		String annee = request.getParameter("annee");
		String semestre = request.getParameter("semestre");
		if( annee == null ) {
			annee = (String) request.getAttribute("annee");
			semestre = (String) request.getAttribute("semestre");
		}
		DAOUser obj = DAOFactory.getInstance().getUserDAO();
		DAOAffectation obj1 = DAOFactory.getInstance().getaffectationDAO();
		List<Affectation> affectations = obj1.getAllaffectation(id_user, annee, semestre);
		List<String> annees = obj.getAll_years_admin(id_user);
		request.setAttribute("annees", annees);
		request.setAttribute("affectations", affectations);
		request.setAttribute("annee", annee);
		request.setAttribute("semestre", semestre);
		if( affectations.size() == 0) {
			request.setAttribute("no_affectation", "No affectation declared for the year and semestre chosen");
		}
		request.getRequestDispatcher("WEB-INF/admin/allAffectations.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
