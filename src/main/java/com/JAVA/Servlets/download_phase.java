package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

import com.JAVA.Beans.Event;
import com.JAVA.Beans.Message;
import com.JAVA.Beans.Phase;
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;
import com.JAVA.DAO.DAOPhase;



public class download_phase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public download_phase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOPhase obj = DAOFactory.getInstance().getphaseDAO();
		int id_phase = Integer.parseInt(request.getParameter("phase_id"));
		int id_projet = Integer.parseInt(request.getParameter("projet_id"));
		Phase phase = obj.getPhase(id_projet,id_phase);
		String fileName = phase.getFile_name();
		InputStream fileData = phase.getFile_data();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(fileData, outputStream);
        outputStream.flush();
        outputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
