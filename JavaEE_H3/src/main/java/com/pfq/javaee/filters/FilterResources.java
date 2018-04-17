package com.pfq.javaee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.pfq.javaee.service.ResourcesService;

public class FilterResources implements Filter {
	
	private  ResourcesService resourcesService;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FilterResources init!");
		this.resourcesService = new ResourcesService();
	}

	@Override
	public void destroy() {
		System.out.println("FilterResources destroy!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("css", resourcesService.getListCSS());
		request.setAttribute("js", resourcesService.getListJS());
        chain.doFilter(request, response);
	}
}
