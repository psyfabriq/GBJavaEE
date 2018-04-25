package com.pfq.javaee.helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

public class Dispatcher {

	private static final Dispatcher instance = new Dispatcher();

	private Dispatcher(){}
	public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageBase = "/WEB-INF/jsf/";
		String pagePath = null;

		pagePath = pageBase + FilenameUtils.getName(request.getRequestURI())+".xhtml";
		request.getServletContext().getRequestDispatcher(pagePath).forward(request, response);
	}
	public static Dispatcher getInstance() {
		return instance;
	}

}