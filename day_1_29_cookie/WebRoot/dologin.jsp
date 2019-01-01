<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dologin.jsp' starting page</title>
    
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
	<h1>登录成功</h1>
	<br>
	<br>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		//判断是否选择了记住登录状态
	 	String [] isUsersCookies = request.getParameterValues("isUserCookie");
		if(isUsersCookies!=null&&isUsersCookies.length>0)
		{
		//把用户名和密码存放在cookie对象里面
		String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
		String password = URLEncoder.encode(request.getParameter("password"), "utf-8");
		
		Cookie usernameCookie = new Cookie("username",username);
		Cookie passwordCookie = new Cookie("password",password);
		
		usernameCookie.setMaxAge(100);
		passwordCookie.setMaxAge(100);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		}
		else//把已经保存的置为失效
		{
			Cookie []cookies =request.getCookies();
			if(cookies!=null&&cookies.length>0)
				{
					for(Cookie c:cookies)
					{
						if(c.getName().equals("username")||c.getName().equals("password"))
						{
							c.setMaxAge(0);//设置coolie失效
							response.addCookie(c);//重新保存
						}
					}
			 	}
		
		}
	%>
	
	<a href="users.jsp" target="_blank">查看用户信息</a>
  </body>
</html>
