<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	 Date data = new Date(); 
	 SimpleDateFormat saf  = new SimpleDateFormat("yyyy年MM月dd日");     
	 
	 String s = saf.format(data);
	 out.println(s);
	
%>

