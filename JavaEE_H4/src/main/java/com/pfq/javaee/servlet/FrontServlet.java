package com.pfq.javaee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfq.javaee.helper.Dispatcher;

public class FrontServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        process(req, resp);
    }    
    private void process(HttpServletRequest request, HttpServletResponse response) {
         Dispatcher dispatcher = Dispatcher.getInstance();
         try {
			dispatcher.dispatch(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
    }
}