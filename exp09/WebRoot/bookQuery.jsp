<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.BookBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="servlet/BookQueryServlet" method="post">
		请输入书号：<input type="text" name="id" id="id" />
		<input type="submit" value="查询" />
<!-- 		
		<%
			BookBean book = (BookBean)request.getAttribute("book");
			out.print(book);
		 %>
		  -->
	</form>
</body>
</html>