    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>

<link type="text/css" rel="stylesheet" href="style/reset.css">
<link type="text/css" rel="stylesheet" href="style/main.css">
  
</head>
<body>
<div class="headerBar">
	<div class="logoBar red_logo">
		<div class="comWidth">
			<div class="logo fl">
				<img src="image/timg.jpg" alt="陕西科技大学" width="82" height="65">
			</div>
			<h3 class="welcome_title">欢迎注册</h3>
		</div>
	</div>
</div> 

<div class="regBox">
	<div class="login_cont">
	<form action="registerServlet" method="post">
		<ul class="login">
			<li><span class="reg_item"><i>*</i>姓名：</span><div class="input_item"><input type="text" class="login_input user_icon" name="user_name"></div></li>
			<li><span class="reg_item"><i>*</i>密码：</span><div class="input_item"><input type="password" class="login_input user_icon" name="user_password"></div></li>
			<li><span class="reg_item"><i>*</i>电话：</span><div class="input_item"><input type="text" class="login_input user_icon" name="user_phone"></div></li>
			<li><span class="reg_item"><i>*</i>身份：</span><div class="input_item">
			<select name="user_power" class="login_input user_icon" >
                	<option value="">老师</option>
                    <option value="">班长</option>
                    <option value="1">学生</option>
                </select></div></li>
			
			<li class="autoLogin"><span class="reg_item">&nbsp;</span><input type="checkbox" id="t1" class="checked"><label for="t1">我同意什么什么条款</label></li>
			<li><input type="submit" value="注册" class="login_btn"></li>
		</ul>
	</form>	
  </div>
</div>
</body>
</html>