<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<link rel="stylesheet" type="text/css" href="css/style_cn.css">

	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">考勤管理</span>
	</div>

   <form action="" method="post">
   	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  		 <tr>
    		<td style="text-align: right;">打卡地点:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.signPlace}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">地理位置(经度):</td>
    		<td><input type="text" style="width: 220px;" value="${sign.longitude}" disabled="disabled"></td>
  		 </tr>
  		 <tr>
    		<td style="text-align: right;">地理位置(纬度):</td>
    		<td><input type="text" style="width: 220px;" value="${sign.latitude}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">打卡范围:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.meter}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">开始生效日期:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.signDate}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">上午开始打卡时间:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.amStartTime}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">上午结束打卡时间:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.amEndTime}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">下午开始打卡时间:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.pmStartTime}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">下午结束打卡时间:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.pmEndTime}" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">迟到规则设置:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.lateTime}分钟" disabled="disabled"></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">严重迟到规则设置:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.tooLateTime}小时" disabled="disabled"></td>
  		 </tr>
  		 <tr>
    		<td style="text-align: right;">旷工规则设置:</td>
    		<td><input type="text" style="width: 220px;" value="${sign.absenceTime}小时" disabled="disabled"></td>
  		 </tr>
	  </table>
	  
	  <hr>
	  
	  <div>
	  	 <a href="sign/updateSign"><input type="button" value="修改"></a>
	  </div>
	  
   </form>
	
  </body>
</html>
