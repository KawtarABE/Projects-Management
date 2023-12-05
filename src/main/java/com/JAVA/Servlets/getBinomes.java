package com.JAVA.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import com.JAVA.Beans.Binome;
import com.JAVA.DAO.DAOBinomes;
import com.JAVA.DAO.DAOFactory;



public class getBinomes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getBinomes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = (String) request.getSession().getAttribute("id_user");
		String year = request.getParameter("year");
		String semestre = request.getParameter("semestre");
		DAOBinomes obj = DAOFactory.getInstance().getbinomesDAO();
		List<Binome> binomes = obj.getAllBinomes(year,semestre,id_user);
		List<Option> options;
		options = filterData(binomes);
		StringBuilder sb = new StringBuilder();
	    for (Option option : options) {
	        sb.append(option.value).append(",").append(option.text).append("\n");
	    }
	    response.setContentType("text/plain");
	    response.getWriter().write(sb.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public List<Option> filterData(List<Binome> binomes) {
		List<Option> options = new ArrayList<Option>();
		for(Binome binome : binomes) {
			Option option = new Option();
			option.value = binome.getId();
			option.text = binome.getStudent1().getNom() + " " + binome.getStudent1().getPrenom() + " et " + binome.getStudent2().getNom() + " " + binome.getStudent2().getPrenom();
			options.add(option);
		}
		return options;
	}
}

class Option {
	public int value;
	public String text;
}

