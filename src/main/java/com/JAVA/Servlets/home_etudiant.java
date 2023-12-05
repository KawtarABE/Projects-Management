package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.JAVA.Beans.Recent;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;
import com.JAVA.DAO.DAOPhase;
import com.JAVA.DAO.DAOProjet;

public class home_etudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public home_etudiant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		DAOEvent obj1 = DAOFactory.getInstance().geteventDao();
		DAOProjet obj2 = DAOFactory.getInstance().getprojetDAO();
		DAOPhase obj3 = DAOFactory.getInstance().getphaseDAO();
		
		String id_user = (String) request.getSession().getAttribute("id_user");
		int count_messages = obj.unreadNumber(id_user);
		int count_events = obj1.comingEvents(id_user);
		int count_projet = obj2.numberProjects(id_user);
		int count_phases = obj3.incompletePhases(id_user);
		int x = obj2.numberIndefinedProjects(id_user);
		count_phases = count_phases + x;
		List<Recent> list = obj3.getRecents(id_user);
		
		request.setAttribute("count_messages", count_messages);
		request.setAttribute("count_events", count_events);
		request.setAttribute("count_projet", count_projet);
		request.setAttribute("count_phases", count_phases);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/home_etudiant.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
