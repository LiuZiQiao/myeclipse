<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'displayBooks.jsp' starting page</title>
  </head>
  
  <body>
	<%@ page import="java.sql.*" %>
	<%
		Connection conn;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","123456");
			String sql = "select *from books";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			//	图书的书号、书名、作者、价格和出版社名称。
			out.print("<table border=\"1\" align=\"center\">");
				out.print("<tr><td>"+"书号"+"</td>");			
				out.print("<td>"+"书名"+"</td>");			
				out.print("<td>"+"作者"+"</td>");			
				out.print("<td>"+"价格"+"</td>");			
				out.print("<td>"+"出版社"+"</td></tr>");			
			while(rs.next()){
				out.print("<tr><td>"+rs.getString(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
				out.print("</tr><br>");
			}
			out.print("</table>");	
		}catch(Exception e){
			e.printStackTrace();
		}
	 %>

  </body>
</html>
