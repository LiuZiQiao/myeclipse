<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'application.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>application内置对象</h1> <br>
    
    <%application.setAttribute("city", "biejing");
      application.setAttribute("postcode", "123456");
      application.setAttribute("email", "132456@qq.com");
     %>
     
     
    所在城市： <%=application.getAttribute("city") %><br>
    application 的属性有：<% 
    Enumeration attributes = application.getAttributeNames();
	while(attributes.hasMoreElements())
	{
    	out.println(attributes.nextElement()+"&nbsp;&nbsp");
	}    
     %>><br>
     JSP(SERVLET)引擎名及版本号:<%=application.getServerInfo() %><br>
  </body>
</html>
