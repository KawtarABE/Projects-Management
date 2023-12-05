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



@MultipartConfig(maxFileSize=169999999)
public class update_phase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update_phase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO(); 
		int id_phase = Integer.parseInt(request.getParameter("id_phase"));
		int id_projet = Integer.parseInt(request.getParameter("id_projet"));
		int id_affectation = Integer.parseInt(request.getParameter("id_affectation"));
		String detail_etudiant = request.getParameter("description");
		String pourcentage = request.getParameter("progress");
		Part filePart = request.getPart("file");
		String fileName = null;
		InputStream fileContent = null;
		if (!filePart.getSubmittedFileName().isEmpty()) {
           fileName = filePart.getSubmittedFileName();
           fileContent = filePart.getInputStream();
		}
		else {
			fileName = obj.getPhase(id_projet, id_phase).getFile_name();
			fileContent = obj.getPhase(id_projet, id_phase).getFile_data();
		}
        obj.modifyPhase(id_phase, pourcentage, detail_etudiant, fileName, fileContent);
		request.setAttribute("success", "Phase successfuly updated");
		request.setAttribute("id_affectation",id_affectation);
		request.setAttribute("id_projet",id_projet);
		request.setAttribute("id_phase",id_phase);
		request.getRequestDispatcher("phase_detail").forward( request, response );
	}

}