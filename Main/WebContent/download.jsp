<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h3>下载文件</h3>


${user }
<a href="${pageContext.request.contextPath }/wordDownloadServlet"> 预览文件</a>
<a href="${pageContext.request.contextPath }/wordDownloadServlet"> 下载文件</a>

</body>
</html>