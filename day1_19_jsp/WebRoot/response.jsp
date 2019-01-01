<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8"%>
<%
	response.setContentType("text/html;charset=utf-8");
	
	out.print("<h1>responsen内置对象</h1>");
	out.println("<hr>");
//	out.flush();
	
	
	PrintWriter outer = response.getWriter();//获得输出流对象
	outer.println("haha");
//	response.sendRedirect("reg.jsp");//请求重定向
	
//	response.sendRedirect("request.jsp");//请求转发
	
	request.getRequestDispatcher("request.jsp").forward(request,response);
 %>