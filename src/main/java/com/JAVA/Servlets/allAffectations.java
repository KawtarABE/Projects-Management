package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOUser;

public class allAffectations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public allAffectations() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = (String) request.getSession().getAttribute("id_user");
		DAOUser obj = DAOFactory.getInstance().getUserDAO();
		List<String> annees = obj.getAll_years_admin(id_user);
		request.setAttribute("annees", annees);
		request.getRequestDispatcher("WEB-INF/admin/allAffectations.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
