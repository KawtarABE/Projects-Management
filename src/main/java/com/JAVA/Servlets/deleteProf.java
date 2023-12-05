package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOProf;

public class deleteProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteProf() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProf obj = DAOFactory.getInstance().getprofDAO();
		String code = request.getParameter("code");
		obj.deleteProf(code);
		request.getRequestDispatcher("allProfs").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
