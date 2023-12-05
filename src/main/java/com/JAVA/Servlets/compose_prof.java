package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Binome;
import com.JAVA.Beans.Message;
import com.JAVA.Beans.User;
import com.JAVA.DAO.DAOBinomes;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;
import com.JAVA.DAO.DAOUser;



public class compose_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public compose_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOBinomes obj = DAOFactory.getInstance().getbinomesDAO();
		DAOUser obj1 = DAOFactory.getInstance().getUserDAO();
		String id_sender = (String) request.getSession().getAttribute("id_user");
		List<Binome> binomes = obj.getAllBinomes_prof(id_sender);
		List<String> semestres = obj1.getAll_semestres(id_sender);
		request.setAttribute("semestres", semestres);
		request.setAttribute("binomes", binomes);
		request.setAttribute("erreur", request.getAttribute("erreur"));
		request.getRequestDispatcher("/WEB-INF/prof/compose_prof.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}