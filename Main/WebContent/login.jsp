<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
<link type="text/css" rel="stylesheet" href="style/reset.css">
<link type="text/css" rel="stylesheet" href="style/main.css">
</head>

<body>
<div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="image/timg.jpg" alt="陕西科技大学" width="67" height="68"></a>
			</div>
			<h3 class="welcome_title">欢迎登陆</h3>
		</div>
	</div>
</div>
<%=request.getAttribute("message") %>
<div class="loginBox">
	<div class="login_cont">
		<form action="loginServlet" method="post">
		<ul class="login">
			<li class="l_tit">用户名</li>
			<li class="mb_10"><input type="text" class="login_input user_icon" name="user_name"></li>
			<li class="l_tit">密码</li>
			<li class="mb_10"><input type="password" class="login_input user_icon" name="user_password" ></li>
			<li class="autoLogin"><input type="checkbox" name="remember" id="a1" class="checked"><label for="a1">自动登陆</label></li>
			<li><input type="submit" value="登录" class="login_btn"></li>
		</ul>
		</form>
		
		<div class="login_partners">
			<p class="l_tit">其他功能</p>
			<ul class="login_list clearfix">
				<li><a href="register.jsp">注册</a></li>
				<li><span>|</span></li>
				<li><a href="notice.jsp">公告栏</a></li>
				<li><span>|</span></li>
				
			</ul>
		</div>
	<marquee direction="left" onMouseOver="this.scrollAmount='1'"onMouseOut="this.scrollAmount='2'"onMouseDown="this.scrollAmount='4'";this.direction='down'"onMouseUp="this.scrollAmount='1';this.direction='up'" scorllAmount="2" height="20">
   
 
      <p height="30" style="color:red;font-size:10pt;font-weight:bold;">
      奖助学金填写于XX月XX日开始,历时三天，请大家注意时间及时填写！
      </p>
  </div>

</div>

</body>
</html>