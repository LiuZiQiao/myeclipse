<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="textml; charset=utf-8" />
    <title>助学金申请表</title>
  <link type="text/css" rel="stylesheet" href="style/table2.css">
    <script type="text/javascript">
		
        function checkidentity2(){
			var a = document.getElementById("useridentity2").value;
			var b = document.getElementById("warningID");
			if(a.length!=18){
				b.style.backgroundImage="url(image/warning.png)";
				return false;
			}
			var last = a.substring(17,18);
			if(isNaN(last)==true&&last!="x"){
				b.style.backgroundImage="url(image/warning.png)";
				return false;
			}
			for(var i = 0;i < 17;i++)
			{
				if(isNaN(a.substring(i,i+1))==true)
				{
					b.style.backgroundImage="url(image/warning.png)";
					return false;
				}
			}
			b.style.backgroundImage="url(image/white.png)";
		}
		function checkphone2(){
			var phone = document.getElementById("userphone2").value;
			var b = document.getElementById("warningphone");
			if(phone.length!=11){
				b.style.backgroundImage="url(image/warning.png)";
				return false;
			}
			b.style.backgroundImage="url(image/white.png)";
		}
		function checkreason2(){
			var reason = document.getElementById("userreason2").value;
			var left = 100-reason.length;
			if(reason.length<100){
				alert("申请理由最少100字，您已输入"+reason.length+"字,还需输入"+left+"字")
			}
		}
		function ensure(){
			if(confirm("您确认要提交吗?")){
				return true;
			}
			else{
				return false;
			}
		}
		
  </script>

  </head>
  
   <body>
  	
    <br>
  	<center>
  	<form action="servlet/table02" method="post" onsubmit="ensure()">
  	<table border="1">
        <tr>
        
        
            <th colspan="8"  >陕西省高等学校国家助学金申请表</th>
        </tr>
        
  		<tr>

  			<td width="37"rowspan="4"id="row1">
			本人情况
		  </td>

  			<td id="row2">
  				姓名
  			</td>

  			<td id="row3" >
  				<input type="text" name="username2" id="row31">
  			</td>

  			<td id="row4" >
  				性别
  			</td>

  			<td id="row5">
          <select name="usersex2">
            <option value="男">男</option>
            <option value="女">女</option>
          </select>
  				
  			</td>

  			<td id="row6" >
  			   出生年月	
  			</td>

  			<td id="row7">
  				<input type="text" name="userbirthday2" value="XXXX.XX" width="80px">
  			</td>

            
            <td rowspan="4" id="row8">
               本人照片
            
            </td>
            

  		</tr>

  		<tr>
  			
  			<td id="row2" >
  				民族
  			</td>

  			<td id="row3">
  				<input type="text" name="usernation2" value="如：汉族" id="row31">
  			</td>

  			<td id="row4">
  				政治面貌
  			</td>

  			<td id="row5" >
  			<select name="userpolitic2">
            	<option value="群众">群众</option>
            	<option value="团员">团员</option>
            	<option value="党员">党员</option>
          </select>
  			</td>

  			<td id="row6" >
  			   入学时间
  			</td>

  			<td id="row7">
  				<select name="userintake2">
            <option value="2014">2014</option>
            <option value="2015">2015</option>
            <option value="2016">2016</option>
            <option value="2017">2017</option>
            <option value="2018">2018</option>
            <option value="2019">2019</option>
            <option value="2020">2020</option>
            <option value="2021">2021</option>      
          </select>
  			</td>

  		</tr>

  		<tr>
  			<td  colspan="2" id="row23">
  				身份证号
  			</td>

  			<td colspan="2" align="left">
  				<input type="text" name="useridentity2" id="useridentity2"  onBlur="checkidentity2()" onfocus="clear()">
  			    <div type="text" name="warning" id="warningID" ></div>
  			</td>

  			<td >
  				联系电话
  			</td>

  			<td align="left">
  				<input type="text" name="userphone2" width="90px" id="userphone2"onBlur="checkphone2()">
  				<div type="text" name="warning" id="warningphone" ></div>
  			</td>

  		</tr>

  		<tr>
  			<td colspan="6">
  				陕西科技大学电气与信息工学院___________班
  			</td>

  		</tr>

  		<tr>
  			
  			<td rowspan="3"id="row1">
  				家庭经济情况
  			</td>

  			<td colspan="2" id="row23" height="30px">
  				家庭户口
  			</td>
            
            <td colspan="3" height="60px">
  				<select name="userfamily2">
            <option value="农村">农村</option> 
            <option value="城镇">城镇</option>   
          </select>
  			</td>
            
            <td id="row7" height="60px">
               家庭总人口数
            </td>
            
            <td height="60px">
               <select name="usernumber2">
                 <option value="1">1</option>
                 <option value="2">2</option>
                 <option value="3">3</option>
                 <option value="4">4</option>
                 <option value="5">5</option>
               </select>
            </td>

  		</tr>

  		<tr height="60px">
  			<td height="39" colspan="2" id="row23" >
               家庭月总收入
            </td>
            
            <td>
            <input type="text" name="userfamily_salary2" value="XXXX元" id="row41">
            </td>
               
            <td>
               人均月收入
            </td>
            
            <td>
            <input type="text" name="usersalary2" value="XXXX元" id="row51">
            </td>
            
            <td id="row7">
               收入来源
            </td>
            
            <td>
            <input type="text" name="userincome2" id="row81">
            </td>
  			
  			
	  </tr>
        
        <tr height="60px">
  			
  			<td height="47" colspan="2" id="row23" >
               家庭住址
            </td>
            
            <td colspan="3">
               <input type="text" name="useraddress2" value="详细到小区楼号或村组" id="useraddress2" width="280px">
            </td>
            
            <td id="row7">
               邮政编码
            </td>
            
            <td><input type="text" name="userpost2" id="row81">
            </td>
  		</tr>
        
        <tr >
            <td rowspan="6" id="row1">
               家庭成员情况
            </td>
            
            <td colspan="2" id="row23">
               姓名
            </td>
            
            <td id="row4">
               年龄
            </td>
            
            <td id="row5">
               与本人关系
            </td>
            
            <td colspan="3">
               工作或学习单位
            </td>
        </tr>
        
        <tr>   
           <td colspan="2">
               <input type="text" name="username01" id="row230">
            </td>
            
            <td>
               <input type="text" name="userage01"id="row41">
            </td>
            
            <td>
              <select name="userrelationship01">
              <option value="爷爷">爷爷</option>
              <option value="奶奶">奶奶</option>
              <option value="父亲">父亲</option>
              <option value="母亲">母亲</option>
              <option value="哥哥">哥哥</option>
              <option value="姐姐">姐姐</option>
              <option value="弟弟">弟弟</option>
              <option value="妹妹">妹妹</option>
              </select>
            </td>
            
            <td colspan="3">
               <input type="text" name="userwork01" id="row78" value="详细到工作单位；如务农则填写家庭住址">
            </td> 
        
        </tr>
        
        <tr>
        
            <td  colspan="2">
              <input type="text" name="username02"id="row230"> 
          </td>
            
            <td>
              <input type="text" name="userage02" id="row41"> 
            </td>
            
            <td>
            <select name="userrelationship02">
              <option value="爷爷">爷爷</option>
              <option value="奶奶">奶奶</option>
              <option value="父亲">父亲</option>
              <option value="母亲">母亲</option>
              <option value="哥哥">哥哥</option>
              <option value="姐姐">姐姐</option>
              <option value="弟弟">弟弟</option>
              <option value="妹妹">妹妹</option>
              </select>
              </td>
            
            <td colspan="3">
              <input type="text" name="userwork02" id="row78"> 
            </td> 
        </tr>
        
        <tr>
        
            <td height="41" colspan="2">
               <input type="text" name="username03" id="row230">
            </td>
            
            <td>
               <input type="text" name="userage03"id="row41"> 
            </td>
            
            <td>
              <select name="userrelationship03">
              <option value="爷爷">爷爷</option>
              <option value="奶奶">奶奶</option>
              <option value="父亲">父亲</option>
              <option value="母亲">母亲</option>
              <option value="哥哥">哥哥</option>
              <option value="姐姐">姐姐</option>
              <option value="弟弟">弟弟</option>
              <option value="妹妹">妹妹</option>
              </select>
            </td>
            
            <td colspan="3">
               <input type="text" name="userwork03" id="row78">
            </td> 
        </tr>
        
        <tr>
        
            <td  colspan="2">
               <input type="text" name="username04"id="row230">
            </td>
            
            <td>
              <input type="text" name="userage04" id="row41">  
            </td>
            
            <td>
             <select name="userrelationship04">
              <option value="爷爷">爷爷</option>
              <option value="奶奶">奶奶</option>
              <option value="父亲">父亲</option>
              <option value="母亲">母亲</option>
              <option value="哥哥">哥哥</option>
              <option value="姐姐">姐姐</option>
              <option value="弟弟">弟弟</option>
              <option value="妹妹">妹妹</option>
              </select>
            </td>
            
            <td colspan="3">
              <input type="text" name="userwork04" id="row78"> 
            </td> 
        </tr>
        
        
        <tr>
        
            <td height="43" colspan="2">
               <input type="text" name="username05" id="row230">
            </td>
            
            <td>
               <input type="text" name="userage05" id="row41"> 
            </td>
            
            <td>
            <select name="userrelationship05">
              <option value="爷爷">爷爷</option>
              <option value="奶奶">奶奶</option>
              <option value="父亲">父亲</option>
              <option value="母亲">母亲</option>
              <option value="哥哥">哥哥</option>
              <option value="姐姐">姐姐</option>
              <option value="弟弟">弟弟</option>
              <option value="妹妹">妹妹</option>
              </select>
            </td>
            
            <td colspan="3">
               <input type="text" name="userwork05" id="row78">
            </td> 
        </tr>
        
        <tr>
            <td colspan="8">
        <p align="left">申请理由:</p>
        <center>
          <textarea style="height:100px; width:600px" name="userreason2" id="userreason2" onBlur="checkreason2()"></textarea>
        </center>
        <p align="left">申请金额：3500、2500元(手勾)</p>
        申请人签名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2017年9月20日
        </td>
        </tr> 
            
        <tr>
        <td colspan="8">
               <p align="left">院系意见：</p><br><br><br>
 
               <p align="right">(公章)2017年9月30日</p>
            </td>
        </tr>
          
            
        <tr>
            <td colspan="8">
              <p align="left"> 学校审核意见：</p><br><br><br>
                
               <p align="right">(公章)2017年9月30日</p>
            </td>
            
         </tr>
  	</table>
  	<input type="submit" value="submit">
  	</form>
    </center>
  </body>
</html>

