package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.JAVA.Beans.Student;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOPhase;
import com.JAVA.DAO.DAOUser;

public class update_phase_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update_phase_prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO(); 
		int id_phase = Integer.parseInt(request.getParameter("id_phase"));
		int id_projet = Integer.parseInt(request.getParameter("id_projet"));
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));
		String detail_prof = request.getParameter("description_prof");
		obj.modifyPhase_prof(id_phase, detail_prof);
		request.setAttribute("success", "Phase successfuly updated");
		request.setAttribute("id_affectation",id_affectation);
		request.setAttribute("id_projet",id_projet);
		request.setAttribute("id_phase",id_phase);
		request.setAttribute("annee", request.getParameter("annee"));
		request.setAttribute("semestre", request.getParameter("semestre"));
		request.getRequestDispatcher("phase_detail_prof").forward( request, response );
	}

}