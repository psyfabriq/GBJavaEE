package com.pfq.javaee.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfq.javaee.service.CatalogService;

@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "Каталог");
		CatalogService cs = new CatalogService();
		req.setAttribute("products", cs.getListProducts());
		req.getRequestDispatcher("/WEB-INF/JSP/catalog.jsp").forward(req, resp);
	}

}
