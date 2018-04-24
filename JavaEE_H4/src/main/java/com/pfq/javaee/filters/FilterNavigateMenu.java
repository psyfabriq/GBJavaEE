package com.pfq.javaee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.pfq.javaee.service.MenuService;

public class FilterNavigateMenu implements Filter {
	
	private  MenuService menuService;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("NavigateMenuFilter init!");
		this.menuService = new MenuService();
	}

	@Override
	public void destroy() {
		System.out.println("NavigateMenuFilter destroy!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("navigatemenu", menuService.getListNavigate());
        chain.doFilter(request, response);
	}
}
