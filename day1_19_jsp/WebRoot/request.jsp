<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'request.jsp' starting page</title>
    
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
   <h1>requset内置对象</h1>
   <%
   request.setCharacterEncoding("utf-8");
    %>
	用户名：<%=request.getAttribute("username") %><hr>
	爱好：<%
	if(request.getParameterValues("favourite")!=null)
	{
		String[] favourites =request.getParameterValues("favourite");
		for(int i=0; i<favourites.length;i++)
		{
			out.println(favourites[i]+"&nbsp;&nbsp;");
		}
	}
	 %>
  </body>
</html>
