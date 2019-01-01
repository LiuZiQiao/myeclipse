<%@page import="javax.xml.crypto.Data"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
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
  <h1>session</h1>
  
  <%SimpleDateFormat nyr = new  SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
   
   Date d = new Date(session.getCreationTime());
   
   session.setAttribute("username","admin");
   session.setAttribute("passward", "123456");
   session.setAttribute("age", 20); 
   
   //设置当前session最大生成期限单位为秒
//   session.setMaxInactiveInterval(10);//10秒；
   %>
   
	session 创建时间：<%=nyr.format(d) %>  <br>
	获取session的ID编号：<%=session.getId() %><br>
	从session中获取的用户名<%=session.getAttribute("username") %><br>
	
	<a href="session2.jsp" target="_blank">跳转到session2页面</a>
  <br>
  </body>
</html>
