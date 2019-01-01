
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 <title>公告栏</title>
 <style type="text/css">
        body{
 margin:0px;
 padding:0px;
}
         div{
 color:#000;
}
  #container{
 width:100%;
 margin:10px 10px 10px 10px; 
 background:#CCC; 
 height:100%;
}
     #header{
 width:60%;
 height:20%;
 background:#ccc; 
 text-align:center;
 font:bold 36px 黑体;
}
       #main{
 width:80%;
 height:70%;
 background-color:#36C;
} 
     #footer{
 width:100%;
 height:10%; 
 background:#ccc;
} 
 </style>
</head>
<body>
<center>
<div id="container">
  <div id="header">公告栏
  </div>
  <div id="main">
     <h3>奖助学金公布于XX月XX日公布，请大家关注</h3>
  </div>
  <div id="footer"></div>
</div> 
</center>		
</body>
</html>