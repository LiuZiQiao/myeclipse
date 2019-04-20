<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSF 'response.jsp' starting page</title>

</head>
  
<body>
<!-- 	hello,<%String name = request.getParameter("username");out.print(name); %>
 -->
	hello,<%String name1 = (String)pageContext.getAttribute("username");
			System.out.println(name1);
			out.print(name1); %>
</body>
</html>