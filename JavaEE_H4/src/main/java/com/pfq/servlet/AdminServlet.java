package com.pfq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

@WebServlet(urlPatterns = "/admin/*")
public class AdminServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        process(req, resp);
    }    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String pageBase = "/jsf/admin/";
		String pagePath = null;
		String pageName = FilenameUtils.getBaseName(request.getRequestURI());
		if (pageName.isEmpty()) {
			request.getServletContext().getRequestDispatcher("/jsf/error.xhtml").forward(request, response);
		} else {
			pagePath = pageBase + pageName + ".xhtml";
			System.out.println(pagePath);

			request.getServletContext().getRequestDispatcher(pagePath).forward(request, response);
		}
    }
}
