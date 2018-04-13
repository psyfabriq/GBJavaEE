package com.pfq.javaee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UTF8Filter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("UTF8Filter init!");
	}

	@Override
	public void destroy() {
		System.out.println("UTF8Filter destroy!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
	}

}
