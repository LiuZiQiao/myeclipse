package com.lxk.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigDemoServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		this.config = config;

		String servletName = config.getServletName();
		System.out.println(servletName);
		String initParameter = config.getInitParameter("email");
		String initParameter1 = config.getInitParameter("telephone");
		
		System.out.println(initParameter);
		System.out.println(initParameter1);
		
		ServletContext servletContext = config.getServletContext();
		
		System.out.println(servletContext);
		
//		System.out.println("Initing ............");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("1223133333333333");
	}

	
}
