<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html >
<title>聊天室</title>
<link href="CSS/style.css" rel="stylesheet">
<script type="text/javascript">
	function check(){
		if(document.getElementById("login").username.value==""){
			alert("请输入用户名！");
			document.getElementById("login").username.focus();
			return false;
		}
		
		if(document.getElementById("login").password.value==""){
			alert("请输入密码名！");
			document.getElementById("login").password.focus();
			return false;
		}
	}
</script>
<body>
	<br>
	<center><h3 style="color:red;">${ msg }</h3></center>
	<form id="login" name="login" method="post" action="servlet/LoginServlet" onSubmit="return check()">
		<input type="hidden" name="method" value="login">
		<table width="371" height="230" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg">
			<tr>
				<td height="120" colspan="3" class="word_dark">&nbsp;</td>
			</tr>
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
				<table width="100%" height="100%">
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="usernum" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" class="word_dark"></td>
			</tr>
			
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
					<table width="100%" height="100%">
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td><input type="password" name="password" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" class="word_dark"></td>
			</tr>
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
				<input name="Submit" type="submit" class="btn_bg" value="登陆">
				<input name="Submit" type="button" class="btn_bg" value="注册" onclick="window.open('regist.jsp')">
				</td>
				<td width="94" valign="top" class="word_dark">
				</td>
			</tr>
			

		</table>
	</form>
</body>
</html>
