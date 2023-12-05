package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Phase;
import com.JAVA.Beans.Student;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOPhase;
import com.JAVA.DAO.DAOUser;




public class phase_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public phase_detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO();
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));
		int id_projet = Integer.parseInt(request.getParameter("id_projet"));
		int id_phase = Integer.parseInt(request.getParameter("id_phase"));
		if( id_affectation == 0) {
			id_affectation = (int) request.getAttribute("id_affectation");
			id_projet = (int) request.getAttribute("id_projet");
			id_phase = (int) request.getAttribute("id_phase");
		}
		Phase phase = obj.getPhase(id_projet, id_phase);
		request.setAttribute("phase", phase);
		request.setAttribute("id_affectation", id_affectation);	
		request.setAttribute("id_projet", id_projet);
		request.getRequestDispatcher("/WEB-INF/phase_detail.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}