<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.CustomerBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="CustomerBean" beanName="customer.lxk" type="Bean.CustomerBean" />
	<%
		out.println( CustomerBean.getCustName());
	 	out.println(CustomerBean.getEmail());
	 	out.println(CustomerBean.getPhone());
	 %>
</body>
</html>