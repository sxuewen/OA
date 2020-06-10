<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
	body {
		background-image: url('images/xueren.jpg');
		background-size: 100% 100%;
		padding: 0;
		margin: 0;
	}
	</style>
  </head>
  
  <body> 
 	 <div style="padding-top: 320px;padding-left: 620px;font-size: 30px;color: brown;"><b>欢迎使用后台管理系统!</b></div>   
   </body>
</html>
