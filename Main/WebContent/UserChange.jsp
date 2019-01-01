<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
</head>
<body>
<div align="center">
<%
    String url = "jdbc:MYSQL:///main";
    String user = "root";
    String password = "18729673011";
    String driverClass = "com.mysql.jdbc.Driver";
    Connection conn = DBUtil.getConnection();
    String application_id1 = request.getParameter("application_id").trim();
    String sql1 = "SELECT * FROM `application`";
    Statement stmt1 = conn.createStatement();
    ResultSet rs1 = stmt1.executeQuery(sql1);
    rs1.next();
    String user_name1 = rs1.getString("user_name").trim();
    String user_sex1 = rs1.getString("user_sex").trim();
    String user_bir1 = rs1.getString("user_bir").trim();
    String user_nation1 = rs1.getString("user_nation").trim();
    String user_idcard1 = rs1.getString("user_idcard").trim();
    String user_politic1 = rs1.getString("user_politic").trim();
    String bank_card1 = rs1.getString("bank_card").trim();
    String user_institute1 = rs1.getString("user_institute").trim();
    String user_department1 = rs1.getString("user_department").trim();
    String user_major1 = rs1.getString("user_major").trim();
    String user_grade1 = rs1.getString("user_grade").trim();
    String user_class1 = rs1.getString("user_class").trim();
    String user_phone1 = rs1.getString("user_phone").trim();
    //8（家庭经济情况）
    String residence1 = rs1.getString("residence").trim();
    String fam_num1 = rs1.getString("fam_num").trim();
    String y_income1 = rs1.getString("y_income").trim();
    String m_income1 = rs1.getString("m_income").trim();
    String mavg_income1 = rs1.getString("mavg_income").trim();
    String income1 = rs1.getString("income").trim();
    String user_address1 = rs1.getString("user_address").trim();
    String user_post1 = rs1.getString("user_post").trim();
  //20（家庭成员情况）
    String username011 = rs1.getString("username01").trim();
    String userage011 = rs1.getString("userage01").trim();
    String userrelationship011 = rs1.getString("userrelationship01").trim();
    String userwork011 = rs1.getString("userwork01").trim();
    
    String username021 = rs1.getString("username02").trim();
    String userage021 = rs1.getString("userage02").trim();
    String userrelationship021 = rs1.getString("userrelationship02").trim();
    String userwork021 = rs1.getString("userwork02").trim();
    
    String username031 = rs1.getString("username03").trim();
    String userage031 = rs1.getString("userage03").trim();
    String userrelationship031 = rs1.getString("userrelationship03").trim();
    String userwork031 = rs1.getString("userwork03").trim();
    
    String username041 = rs1.getString("username04").trim();
    String userage041 = rs1.getString("userage04").trim();
    String userrelationship041 = rs1.getString("userrelationship04").trim();
    String userwork041 = rs1.getString("userwork04").trim();
    
    String username051 = rs1.getString("username05").trim();
    String userage051 = rs1.getString("userage05").trim();
    String userrelationship051 = rs1.getString("userrelationship05").trim();
    String userwork051 = rs1.getString("userwork05").trim();
  //2（奖助学金）
    String stipend1 = rs1.getString("stipend").trim();
    String burse1 = rs1.getString("burse").trim();
    rs0.close();
    stmt.close();
%>
<form method="post" action="applyingServlet" onsubmit="ensure()">

		<table border="1">
			<tr>
				<th colspan="11"><div align="center">奖助学金基本信息修改</div></th>
			</tr>
			<tr>

				<td width="60" rowspan="4" id="col_td1">
					<p align="center">学生</p>
					<p align="center">本人</p>
					<p align="center">基本</p>
					<p align="center">情况</p>
				</td>

				<td width="60" id="col_td1" height="40px">姓名</td>

				<td width="74">
				   <input type="text" name="user_name"id="input_min" value="<%=user_name1%>">
				</td>

				<td width="134">性别</td>

				<td width="56">
				   <input type="text" name="user_sex" value="<%=user_sex1%>">
				</td>

				<td colspan="2">出生年月</td>

				<td id="col_td3">
				   <input type="text" name="user_bir"value="<%=user_bir1%>" id="input_min">
				</td>

				<td width="60" id="col_td1">民族</td>

				<td id="col_td2">
				   <input type="text" name="user_nation"value="<%=user_nation1%>" id="input_mid">
				</td>

			</tr>

			<tr>
				<td colspan="2" id="col_td2" height="40px">身份证号码</td>

				<td colspan="2">
				   <input type="text" id="ID" name="user_idcard" value="<%=user_idcard1%>"onBlur="checkID()">
				</td>

				<td id="input_mid">政治面貌</td>

				<td id="input_mid">
				 <input type="text" name="user_politic" value="<%=user_politic1%>">
		        </td>

				<td colspan="2">银行卡</td>

				<td id="col_td2">
				<input type="text" name="bank_card"id="input_mid" value="<%=bank_card1%>">
				</td>

			</tr>

			<tr>
				<td id="col_td1" height="40px">学院</td>

				<td colspan="2">
				   <input type="text" name="user_institute" value="<%=user_institute1%>">
				</td>

				<td id="col_td1">系</td>

				<td colspan="2">
				    <input type="text" name="user_department"id="input_mid" value="<%=user_department1%>">
				</td>

				<td>专业</td>

				<td colspan="2">
				   <input type="text" name="user_major"id="input_mid" value="<%=user_major1%>">
				</td>

			</tr>

			<tr>
				<td id="col_td1" height="40px">年级</td>

				<td colspan="2">
				   <input type="text" name="user_grade" value="<%=user_grade1%>">
				</td>

				<td id="col_td1">班级</td>

				<td><input type="text" name="user_class" id="input_mid" value="<%=user_class1%>">
				</td>

				<td colspan="2">联系电话</td>

				<td colspan="2">
				   <input type="text" name="user_phone" id="phone"onBlur="checkphone()" value="<%=user_phone1%>">
			    </td>

			</tr>
			<tr>

				<td rowspan="3" id="col_td1">
					<p align="center">家庭</p>
					<p align="center">经济</p>
					<p align="center">情况</p>
				</td>

				<td colspan="2" id="col_td2" height="40px">家庭户口</td>

				<td>
				   <input type="text" name="residence" value="<%=residence1%>">
				</td>

				<td colspan="2">家庭总人口数</td>

				<td height="60px">
				    <input type="text" name="fam_num" value="<%=fam_num1%>">
				</td>

				<td colspan="2">家庭年总收入</td>

				<td id="col_td2">
				   <input type="text" name="y_income"id="input_mid" value="<%=y_income1%>">
				</td>

			</tr>

			<tr>
				<td colspan="2" id="col_td2" height="40px">家庭月总收入</td>

				<td>
				   <input type="text" name="m_income" value="<%=m_income1%>"id="input_mid">
				</td>

				<td colspan="2">人均月收入</td>

				<td>
				   <input type="text" name="mavg_income" value="<%=mavg_income%>"id="input_mid">
				</td>

				<td colspan="2">收入来源</td>

				<td id="col_td2">
				    <input type="text" name="income" value="<%=income1%>"id="input_mid">
				</td>


			</tr>

			<tr>

				<td colspan="2" id="col_td2" height="40px">家庭住址</td>

				<td colspan="3">
				   <input type="text" name="user_address"value="<%=user_address1%>" id="input_max">
				</td>

				<td colspan="2">邮政编码</td>

				<td colspan="2">
				   <input type="text" name="user_post" value="<%=user_post1%>"id="input_mid">
				</td>
			</tr>

			<tr>
				<td rowspan="6" id="col_td1">
					<p align="center">家庭</p>
					<p align="center">成员</p>
					<p align="center">情况</p>
				</td>

				<td colspan="2" id="col_td2" height="40px">姓名</td>

				<td colspan="2">年龄</td>

				<td colspan="2">与本人关系</td>

				<td colspan="3">工作或学习单位</td>
			</tr>

			<tr>
				<td colspan="2" height="40px">
				   <input type="text"name="username01" id="input_min" value="<%=username011%>">
				</td>

				<td colspan="2">
				   <input type="text" name="userage01"id="input_min"  value="<%=userage011%>">
				</td>

				<td colspan="2">
				   <input type="text" name="userrelationship01" value="<%=userrelationship011%>">
				</td>

				<td colspan="3">
				   <input type="text" name="userwork01"value="<%=userwork011%>" id="input_max">
				</td>

			</tr>

			<tr>

				<td colspan="2" height="40px">
				   <input type="text" value="<%=username021%>"name="username02" id="input_min">
				</td>

				<td colspan="2">
				   <input type="text" name="userage02" value="<%=userage021%>"id="input_min">
				</td>

				<td colspan="2">
				   <input type="text" name="userrelationship02" value="<%=userrelationship021%>">
				</td>

				<td colspan="3">
				   <input type="text" name="userwork02" value="<%=userwork021%>"id="input_max">
				</td>
			</tr>

			<tr>

				<td colspan="2" height="40px">
				   <input type="text" name="username03" id="input_min" value="<%=username031%>">
				</td>

				<td colspan="2">
				   <input type="text" name="userage03" value="<%=userage031%>" id="input_min">
				</td>

				<td colspan="2">
				   <input type="text"name="userrelationship03" value="<%=userrelationship031%>" >
				</td>

				<td colspan="3">
				   <input type="text" name="userwork03"id="input_max"value="<%=userwork031%>">
				</td>
			</tr>

			<tr>

				<td colspan="2" height="40px">
				   <input type="text"name="username04" id="input_min"value="<%=username041%>" >
				</td>

				<td colspan="2">
				   <input type="text" name="userage04"id="input_min" value="<%=userage041%>">
				</td>

				<td colspan="2">
				   <input type="text" name="userrelationship04" value="<%=userrelationship041%>">
				</td>

				<td colspan="3">
				   <input type="text" name="userwork04"id="input_max" value="<%=userwork041%>">
				</td>
			</tr>

			<tr>

				<td colspan="2" height="40px">
				  <input type="text"name="username05" id="input_min" value="<%=username051%>">
				</td>

				<td colspan="2">
				   <input type="text" name="userage05"id="input_min" value="<%=userage051%>">
				</td>

				<td colspan="2">
				    <input type="text" name="userrelationship05" value="<%=userrelationship051%>">
				</td>

				<td colspan="3">
				   <input type="text" name="userwork05"id="input_max" value="<%=userwork051%>">
				</td>
			</tr>

			<tr>

				<td id="col_td1">
					<p align="center">助学</p>
					<p align="center">金申</p>
					<p align="center">请理</p>
					<p align="center">由</p>
				</td>

				<td colspan="10">
					<center>
						<textarea onBlur="checkreason1()" id="reason1" name="stipend" value="<%=stipend1%>"></textarea>
					</center>
				</td>

			</tr>
			<tr>

				<td id="col_td1">
					<p align="center">奖学</p>
					<p align="center">金申</p>
					<p align="center">请理</p>
					<p align="center">由</p>
				</td>

				<td colspan="10">
					<center>
						<textarea onBlur="checkreason2()" id="reason2" name="burse" value="<%=burse1%>"></textarea>
					</center>
				</td>

			</tr>

		</table>
		<center>
			<input type="submit" value="提交"><input type="reset"
				value="重置">
		</center>
	</form>
</div>
</body>
</html>