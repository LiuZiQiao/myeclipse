package com.lxk.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {

	public CountServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		Integer times =  (Integer)servletContext.getAttribute("times");
		if(times == null)
		{
			times = new Integer(1);
		}else{
			times = new Integer(times.intValue()+1);
		}
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>");
		out.println("页面访问统计");
		out.println("</title></head><body>");
		out.println("<h1>当前第"+times+"次访问</h1>");
		out.println("</body>");
		servletContext.setAttribute("times", times);
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
