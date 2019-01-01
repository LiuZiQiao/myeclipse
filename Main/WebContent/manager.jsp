<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.*"  import ="utils.DBUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员管理页面</title>
</head>
<body>
  <%
   try{
	   String url = "jdbc:MYSQL:///main";
	   String user = "root";
	   String password = "123456";
	   String driverClass = "com.mysql.jdbc.Driver";
	   Connection conn = null;
	   conn = DBUtil.getConnection();
	   ResultSet rs = null;
	   Statement stmt = conn.createStatement();
  %>
  <table border="1">
       <tr>
          <td>姓名</td>
          <td>班级</td>
          <td>学院</td>
          <td>身份证号</td>
          <td>银行卡号</td>
          <td>电话</td>
          <td>家庭年收入</td>
          <td>奖学金申请理由</td>
          <td>助学金申请理由</td>
          <td>操作</td>
       </tr>
       <%
       String sql = "SELECT * FROM `application`";//查询所有数据
       rs = stmt.executeQuery(sql);
       int intPageSize;//一页显示的记录数
       int intRowCount;//记录的总数
       int intPageCount;//总页数
       int intPage;//待显示的页码
       String strPage;
       int i;
       intPageSize = 10;//设置一页显示的记录数
       strPage = request.getParameter("page");//取得待显示的页码
       if(strPage==null)
    	   //判断strPage是否为空，如果是，显示第一页数据
       {
    	   intPage = 1;
       }else{
           intPage = java.lang.Integer.parseInt(strPage);//将字符串转换为整形
       }
       if(intPage<1){
    	   intPage=1;
       }
       rs.last();//获取记录总数
       intRowCount = rs.getRow();
       intPageCount = (intRowCount + intPageSize - 1)/intPageSize;//计算总页数
           if(intPage>intPageCount)
        	   intPage = intPageCount;//调整待显示的页码
           if(intPageCount>0){
        	   rs.absolute((intPage-1)*intPageSize+1);
           }
        	 //下面用于显示数据
        	 i = 0;
        	 while(i<intPageSize&&!rs.isAfterLast()){
      
       %>
    		 <tr>
    		   <td><%=rs.getString("user_name") %></td>
    		   <td><%=rs.getString("user_class") %></td>
    		   <td><%=rs.getString("user_institute") %></td>
    		   <td><%=rs.getString("y_income") %></td>
    		   <td><%=rs.getString("user_idcard") %></td>
    		   <td><%=rs.getString("bank_card") %></td>
    		   <td><%=rs.getString("user_phone") %></td>
    		   <td><%=rs.getString("burse") %></td>
    		   <td><%=rs.getString("stipend") %></td>
    		   <td>
    		      
    		      <a href="UserChange.jsp">修改</a>
    		      
    		   </td>
    		   </tr>
     <%
       rs.next();
     i++;
        	 }
        	 rs.close();//释放资源
        	 stmt.close();
        	 conn.close();
     %>
     <tr>
     <td colspan="10">共<%=intRowCount %>个记录，
     <%=intPageCount%>页显示/当前第<%=intPage %>页
     <%
       for(int j=i;j<intPageCount;j++){
    	   out.print("&nbsp;&nbsp;<a href='manager.jsp?page="+j+"'>"+j+"</a>");
       }
   }catch(Exception e){
	   e.printStackTrace();
   }
     %>
     </td>
     </tr>
  </table>
</body>
</html>