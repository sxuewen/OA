<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<link type="text/css" href="css/top.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

  	<script type="text/javascript">
  	
		function tick() {
		var hours, minutes, seconds;
		var intHours, intMinutes, intSeconds;
		var today;
		today = new Date();
		intYear = today.getFullYear();
		intMonth = today.getMonth() + 1;
		intDay = today.getDate();
		intHours = today.getHours();
		intMinutes = today.getMinutes();
		intSeconds = today.getSeconds();
		
		if (intHours == 0) {
			hours = "00:";
		} else if (intHours < 10) { 
			hours = "0" + intHours+":";
		} else {
			hours = intHours + ":";
		}
		
		if (intMinutes < 10) {
			minutes = "0"+intMinutes+":";
		} else {
			minutes = intMinutes+":";
		}
		if (intSeconds < 10) {
			seconds = "0"+intSeconds+" ";
		} else {
			seconds = intSeconds+" ";
		} 
		timeString = intYear + "年" + intMonth + "月" + intDay + "日" + " " + hours+minutes+seconds+" 星期"+"日一二三四五六".charAt(new Date().getDay());
		document.getElementById("clock").innerHTML = timeString;
		window.setTimeout("tick();", 1000);
		}
	
	  	window.onload = tick;
	  	
	  	/* $(function(){
		  	setInterval("document.getElementById('clock').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000); 
	  	}); */
  	</script>
  	
  	<!-- <style type="text/css">
  	
  	body {
		background-image: url('images/tim.gif');
		background-size: 50% 100%;
		padding: 0;
		margin: 0;
	}
  	</style> -->
  </head>
  
  <body>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="top">
  	<tr> 
    	<td class="logo"> 
        	<div id="time" class="subNav">${sessionScope.sfUserName}，欢迎您！当前时间：<span id="clock"></span> | <a href="staff/exitSystem">退出&nbsp;</a></div>
    	</td>
  	</tr>
	</table>
  </body>
</html>
