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
import com.JAVA.DAO.DAOEvent;
import com.JAVA.DAO.DAOFactory;
import com.JAVA.DAO.DAOMessage;



public class download extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public download() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMessage obj = DAOFactory.getInstance().getMessageDAO();
		int id_message = Integer.parseInt(request.getParameter("message_id"));
		Message message = obj.getMessage(id_message);
		String fileName = message.getFile_name();
		InputStream fileData = message.getFile_data();
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
