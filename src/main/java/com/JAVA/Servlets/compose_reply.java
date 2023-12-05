package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import com.JAVA.Beans.Message;
import com.JAVA.Beans.User;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;



public class compose_reply extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public compose_reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		String id_receiver = request.getParameter("receiver");
		String receiver = obj.getUser(id_receiver);
		int isresponse_to = Integer.parseInt(request.getParameter("isresponse_to"));
		request.setAttribute("receiver", receiver);
		request.setAttribute("id_receiver", id_receiver);
		request.setAttribute("isresponse_to", isresponse_to);
		request.getRequestDispatcher("/WEB-INF/compose_reply.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}