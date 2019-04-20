<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.CustomerBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="CustomerBean" class="Bean.CustomerBean" />
	
	<%
		CustomerBean.setCustName(request.getParameter("custName"));
	  	CustomerBean.setEmail(request.getParameter("email"));
	  	CustomerBean.setPhone(request.getParameter("phone"));
	  	CustomerBean.setValid(request.getParameter("valid")!= null);
	 %>
	 
</body>
</html>