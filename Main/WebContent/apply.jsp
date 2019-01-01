<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>陕西科技大学奖助学金在线申请</title>
<script type="text/javascript">
	function checkID() {
		var a = document.getElementById("ID").value;
		var b = document.getElementById("warningID");
		if (a.length != 18) {
			b.style.backgroundImage = "url(image/warning.png)";
			return false;
		}
		var last = a.substring(17, 18);
		if (isNaN(last) == true && last != "x") {
			b.style.backgroundImage = "url(image/warning.png)";
			return false;
		}
		for (var i = 0; i < 17; i++) {
			if (isNaN(a.substring(i, i + 1)) == true) {
				b.style.backgroundImage = "url(image/warning.png)";
				return false;
			}
		}
		b.style.backgroundImage = "url(image/white.png)";
	}
	function checkphone() {
		var phone = document.getElementById("phone").value;
		var b = document.getElementById("warningphone");
		if (phone.length != 11) {
			b.style.backgroundImage = "url(image/warning.png)";
			return false;
		}
		b.style.backgroundImage = "url(image/white.png)";
	}

	function checkreason1() {
		var reason = document.getElementById("reason1").value;
		var left = 100 - reason.length;
		if (reason.length < 100) {
			alert("申请理由最少100字，您已输入" + reason.length + "字,还需输入" + left + "字")
		}
	}
	function checkreason2() {
		var reason = document.getElementById("reason2").value;
		var left = 100 - reason.length;
		if (reason.length < 100) {
			alert("申请理由最少100字，您已输入" + reason.length + "字,还需输入" + left + "字")
		}
	}
	function ensure() {
		if (confirm("您确认要提交吗?")) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>

	<form method="post" action="applyingServlet" onsubmit="ensure()">

		<table border="1">
			<tr>
				<th colspan="11"><div align="center">奖助学金基本信息填写</div></th>
			</tr>
			<tr>

				<td width="60" rowspan="4" id="col_td1">
					<p align="center">学生</p>
					<p align="center">本人</p>
					<p align="center">基本</p>
					<p align="center">情况</p>
				</td>

				<td width="60" id="col_td1" height="40px">姓名</td>

				<td width="74"><input type="text" name="user_name"
					id="input_min"></td>

				<td width="134">性别</td>

				<td width="56"><select name="user_sex">
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>

				<td colspan="2">出生年月</td>

				<td id="col_td3"><input type="text" name="user_bir"
					value="如:1998.03" id="input_min"></td>

				<td width="60" id="col_td1">民族</td>

				<td id="col_td2"><input type="text" name="user_nation"
					value="如:汉族" id="input_mid"></td>

			</tr>

			<tr>
				<td colspan="2" id="col_td2" height="40px">身份证号码</td>

				<td colspan="2"><input type="text" id="ID" name="user_idcard"
					onBlur="checkID()"></td>

				<td id="input_mid">政治面貌</td>

				<td id="input_mid"><select name="user_politic">
						<option value="群众">群众</option>
						<option value="团员">团员</option>
						<option value="党员">党员</option>
				</select></td>

				<td colspan="2">银行卡</td>

				<td id="col_td2"><input type="text" name="bank_card"
					id="input_mid"></td>

			</tr>

			<tr>
				<td id="col_td1" height="40px">学院</td>

				<td colspan="2"><select name="user_institute">
						<option value="机电工程学院">机电工程学院</option>
						<option value="电气与信息工程学院">电气与信息工程学院</option>
						<option value="轻工科学与工程">轻工科学与工程学院</option>
						<option value="材料科学与工程学院">材料科学与工程学院</option>
						<option value="环境科学与工程学院">环境科学与工程学院</option>
						<option value="食品与生物工程学院">食品与生物工程学院</option>
						<option value="经济与管理学院">经济与管理学院</option>
						<option value="化学与化工学院">化学与化工学院</option>
						<option value="设计与艺术学院">设计与艺术学院</option>
						<option value="文理学院">文理学院</option>
						<option value="职业技术学院">职业技术学院</option>
						<option value="马克思主义学院">马克思主义学院</option>
				</select></td>

				<td id="col_td1">系</td>

				<td colspan="2"><input type="text" name="user_department"
					id="input_mid"></td>

				<td>专业</td>

				<td colspan="2"><input type="text" name="user_major"
					id="input_mid"></td>

			</tr>

			<tr>
				<td id="col_td1" height="40px">年级</td>

				<td colspan="2"><select name="user_grade">
						<option value="2014级">2014级</option>
						<option value="2015级">2015级</option>
						<option value="2016级">2016级</option>
						<option value="2017级">2017级</option>
				</select></td>

				<td id="col_td1">班级</td>

				<td><input type="text" name="user_class" id="input_mid">
				</td>

				<td colspan="2">联系电话</td>

				<td colspan="2"><input type="text" name="user_phone" id="phone"
					onBlur="checkphone()"></td>

			</tr>
			<tr>

				<td rowspan="3" id="col_td1">
					<p align="center">家庭</p>
					<p align="center">经济</p>
					<p align="center">情况</p>
				</td>

				<td colspan="2" id="col_td2" height="40px">家庭户口</td>

				<td><select name="residence">
						<option value="农村">农村</option>
						<option value="城镇">城镇</option>
				</select></td>

				<td colspan="2">家庭总人口数</td>

				<td height="60px"><select name="fam_num">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></td>

				<td colspan="2">家庭年总收入</td>

				<td id="col_td2"><input type="text" name="y_income"
					value="XXXX元" id="input_mid"></td>

			</tr>

			<tr>
				<td colspan="2" id="col_td2" height="40px">家庭月总收入</td>

				<td><input type="text" name="m_income" value="XXXX元"
					id="input_mid"></td>

				<td colspan="2">人均月收入</td>

				<td><input type="text" name="mavg_income" value="XXXX元"
					id="input_mid"></td>

				<td colspan="2">收入来源</td>

				<td id="col_td2"><input type="text" name="income"
					id="input_mid"></td>


			</tr>

			<tr>

				<td colspan="2" id="col_td2" height="40px">家庭住址</td>

				<td colspan="3"><input type="text" name="user_address"
					value="详细到小区楼号或村组" id="input_max"></td>

				<td colspan="2">邮政编码</td>

				<td colspan="2"><input type="text" name="user_post"
					id="input_mid"></td>
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
				<td colspan="2" height="40px"><input type="text"
					name="username01" id="input_min"></td>

				<td colspan="2"><input type="text" name="userage01"
					id="input_min"></td>

				<td colspan="2"><select name="userrelationship01">
						<option value="爷爷">爷爷</option>
						<option value="奶奶">奶奶</option>
						<option value="父亲">父亲</option>
						<option value="母亲">母亲</option>
						<option value="哥哥">哥哥</option>
						<option value="姐姐">姐姐</option>
						<option value="弟弟">弟弟</option>
						<option value="妹妹">妹妹</option>
				</select></td>

				<td colspan="3"><input type="text" name="userwork01"
					value="详细到工作单位；如务农则填写家庭住址" id="input_max"></td>

			</tr>

			<tr>

				<td colspan="2" height="40px"><input type="text"
					name="username02" id="input_min"></td>

				<td colspan="2"><input type="text" name="userage02"
					id="input_min"></td>

				<td colspan="2"><select name="userrelationship02">
						<option value="爷爷">爷爷</option>
						<option value="奶奶">奶奶</option>
						<option value="父亲">父亲</option>
						<option value="母亲">母亲</option>
						<option value="哥哥">哥哥</option>
						<option value="姐姐">姐姐</option>
						<option value="弟弟">弟弟</option>
						<option value="妹妹">妹妹</option>
				</select></td>

				<td colspan="3"><input type="text" name="userwork02"
					id="input_max"></td>
			</tr>

			<tr>

				<td colspan="2" height="40px"><input type="text"
					name="username03" id="input_min"></td>

				<td colspan="2"><input type="text" name="userage03"
					id="input_min"></td>

				<td colspan="2"><select name="userrelationship03">
						<option value="爷爷">爷爷</option>
						<option value="奶奶">奶奶</option>
						<option value="父亲">父亲</option>
						<option value="母亲">母亲</option>
						<option value="哥哥">哥哥</option>
						<option value="姐姐">姐姐</option>
						<option value="弟弟">弟弟</option>
						<option value="妹妹">妹妹</option>
				</select></td>

				<td colspan="3"><input type="text" name="userwork03"
					id="input_max"></td>
			</tr>

			<tr>

				<td colspan="2" height="40px"><input type="text"
					name="username04" id="input_min"></td>

				<td colspan="2"><input type="text" name="userage04"
					id="input_min"></td>

				<td colspan="2"><select name="userrelationship04">
						<option value="爷爷">爷爷</option>
						<option value="奶奶">奶奶</option>
						<option value="父亲">父亲</option>
						<option value="母亲">母亲</option>
						<option value="哥哥">哥哥</option>
						<option value="姐姐">姐姐</option>
						<option value="弟弟">弟弟</option>
						<option value="妹妹">妹妹</option>
				</select></td>

				<td colspan="3"><input type="text" name="userwork04"
					id="input_max"></td>
			</tr>

			<tr>

				<td colspan="2" height="40px"><input type="text"
					name="username05" id="input_min"></td>

				<td colspan="2"><input type="text" name="userage05"
					id="input_min"></td>

				<td colspan="2"><select name="userrelationship05">
						<option value="爷爷">爷爷</option>
						<option value="奶奶">奶奶</option>
						<option value="父亲">父亲</option>
						<option value="母亲">母亲</option>
						<option value="哥哥">哥哥</option>
						<option value="姐姐">姐姐</option>
						<option value="弟弟">弟弟</option>
						<option value="妹妹">妹妹</option>
				</select></td>

				<td colspan="3"><input type="text" name="userwork05"
					id="input_max"></td>
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
						<textarea onBlur="checkreason1()" id="reason1" name="stipend"></textarea>
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
						<textarea onBlur="checkreason2()" id="reason2" name="burse"></textarea>
					</center>
				</td>

			</tr>

		</table>
		<center>
			<input type="submit" value="提交"><input type="reset"
				value="重置">
		</center>
	</form>
</body>
</html>