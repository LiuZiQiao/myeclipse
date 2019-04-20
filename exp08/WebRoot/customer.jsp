<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveBean.jsp">
		custName:<input type="text" name="custName" id="custName" />
		email:<input type="text" name="email" id="email" />
		phone:<input type="text" name="phone" id="phone" />
		valid:<input type="checkbox" name="valid" id="valid"/>
		<input type="button" value="提交">
	</form>
</body>
</html>